package com.example.service;


import java.util.EnumMap;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.Facet;
import com.google.code.linkedinapi.schema.Facets;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;


@Controller
@RequestMapping("/linkedin")
public class LinkedInService {

	 /**
     * Consumer Key
     */
    private static final String CONSUMER_KEY_OPTION = "909ogw5bv7du";
        
    /**
     * Consumer Secret
     */
    private static final String CONSUMER_SECRET_OPTION = "nLlOFkfExCH9yfAj";
    
    /**
     * Access Token
     */
    private static final String ACCESS_TOKEN_OPTION = "4fb374d7-4580-4025-9f08-86bfe3d244e4";
        
    /**
     * Access Token Secret
     */
    private static final String ACCESS_TOKEN_SECRET_OPTION = "113d86a8-29ac-447d-ac05-83c222cde7d4";

    /**
     * keywords
     */
    private static final String KEYWORDS_OPTION = "salesforce";
    
    /**
     * name
     */
    private static final String NAME_OPTION = "Irene Haque";
    
    /**
     * company
     */
    private static final String COMPANY_OPTION = "Rocket Lawyer";
    
    /**
     * is current company
     */
    private static final String CURRENT_COMPANY_OPTION = "Lending Club";
    
    /**
     * title
     */
    private static final String TITLE_OPTION = "Software Engineer";
    
    /**
     * current-title
     */
    private static final String CURRENT_TITLE_OPTION = "Software Developer";
    
    /**
     * industry-code
     */
    private static final String INDUSTRY_CODE_OPTION = "industry_code";
    
    /**
     * search-location-type
     */
    private static final String SEARCH_LOCATION_TYPE_OPTION = "search_location_type";
    
    /**
     * country-code
     */
    private static final String COUNTRY_CODE_OPTION = "country_code";
    
    /**
     * postal-code
     */
    private static final String POSTAL_CODE_OPTION = "postal_code";
    
    /**
     * network
     */
    private static final String NETWORK_OPTION = "network";
    
    /**
     * Name of the help command line option.
     */
    private static final String HELP_OPTION = "help";
    
    /**
         * @param args
         */
        public static void main(String[] args) {
        	search();
        }
        
    /**
     * Process command line options and call the service. 
     */
        
    private static LinkedInApiClient config()
    {
    	 final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(CONSUMER_KEY_OPTION, CONSUMER_SECRET_OPTION);
         final LinkedInApiClient client = factory.createLinkedInApiClient(ACCESS_TOKEN_OPTION, ACCESS_TOKEN_SECRET_OPTION);
         return client;
    }
    private static void search() {
                System.out.println("Searching for users.");
                People people = config().searchPeople();
                printResult(people);
    }
        
   
    /**
     * Print the result of API call.
     */
    private static void printResult(People people) {
        System.out.println("================================");
        System.out.println("Total search result:" + people.getCount());
        for (Person person : people.getPersonList()) {
                System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline() + ":" + person.getPublicProfileUrl() + ":" + person.getPictureUrl() + ":" + person.getTwitterAccounts());
        }
        }
    
        private static void printResult(Facets facets) {
        System.out.println("================================");
        System.out.println("Total facet result:" + facets.getTotal());
        for (Facet facet : facets.getFacetList()) {
                System.out.println(facet.getName() + ":" + facet.getCode());
        }
        }

        private static Map<SearchParameter, String> getSearchParameters(CommandLine line) {
                Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
                
                if (line.hasOption(KEYWORDS_OPTION)) {
                        searchParameters.put(SearchParameter.KEYWORDS, line.getOptionValue(KEYWORDS_OPTION));
                }
                
                if (line.hasOption(NAME_OPTION)) {
                        searchParameters.put(SearchParameter.FIRST_NAME, line.getOptionValue(NAME_OPTION));
                }
                
                if (line.hasOption(COMPANY_OPTION)) {
                        searchParameters.put(SearchParameter.COMPANY_NAME, line.getOptionValue(COMPANY_OPTION));
                }
                
                if (line.hasOption(CURRENT_COMPANY_OPTION)) {
                        searchParameters.put(SearchParameter.CURRENT_COMPANY, line.getOptionValue(CURRENT_COMPANY_OPTION));
                }
                
                if (line.hasOption(TITLE_OPTION)) {
                        searchParameters.put(SearchParameter.TITLE, line.getOptionValue(TITLE_OPTION));
                }
                
                if (line.hasOption(CURRENT_TITLE_OPTION)) {
                        searchParameters.put(SearchParameter.CURRENT_TITLE, line.getOptionValue(CURRENT_TITLE_OPTION));
                }
                
                if (line.hasOption(COUNTRY_CODE_OPTION)) {
                        searchParameters.put(SearchParameter.COUNTRY_CODE, line.getOptionValue(COUNTRY_CODE_OPTION));
                }
                
                if (line.hasOption(POSTAL_CODE_OPTION)) {
                        searchParameters.put(SearchParameter.POSTAL_CODE, line.getOptionValue(POSTAL_CODE_OPTION));
                }
                
                return searchParameters;
        }

}
