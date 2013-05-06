package com.example.service;


import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.Parameter;
import com.google.code.linkedinapi.client.constant.LanguageCodes;
import com.google.code.linkedinapi.client.constant.RelationshipCodes;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.Facet;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.Facets;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;


@Controller
@RequestMapping("/linkedin")
public class LinkedInService {
    private static final String CONSUMER_KEY_OPTION = "909ogw5bv7du";
    private static final String CONSUMER_SECRET_OPTION = "nLlOFkfExCH9yfAj";
    private static final String ACCESS_TOKEN_OPTION = "4fb374d7-4580-4025-9f08-86bfe3d244e4";
    private static final String ACCESS_TOKEN_SECRET_OPTION = "113d86a8-29ac-447d-ac05-83c222cde7d4";
    private static final String KEYWORDS_OPTION = "salesforce";
    private static final String NAME_OPTION = "Irene Haque";
    private static final String COMPANY_OPTION = "Rocket Lawyer";
    private static final String CURRENT_COMPANY_OPTION = "Lending Club";
    private static final String TITLE_OPTION = "Software Engineer";
    private static final String CURRENT_TITLE_OPTION = "Software Developer";
    private static final String INDUSTRY_CODE_OPTION = "industry_code";
    private static final String SEARCH_LOCATION_TYPE_OPTION = "search_location_type";
    private static final String COUNTRY_CODE_OPTION = "country_code";
    private static final String POSTAL_CODE_OPTION = "postal_code";
    private static final String NETWORK_OPTION = "network";
    private static final String HELP_OPTION = "help";
    
    public static void main(String[] args) 
    {
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
    			Map<SearchParameter, String> searchParameters = new HashMap<SearchParameter, String>();
                List<Parameter<FacetType, String>> facets = new ArrayList<Parameter<FacetType,String>>();
                facets.add(new Parameter<FacetType, String>(FacetType.NETWORK, RelationshipCodes.OUT_OF_NETWORK_CONNECTIONS));
                facets.add(new Parameter<FacetType, String>(FacetType.NETWORK, RelationshipCodes.SECOND_DEGREE_CONNECTIONS));
                facets.add(new Parameter<FacetType, String>(FacetType.LANGUAGE, LanguageCodes.ENGLISH));
                PeopleSearch people = config().searchPeople(searchParameters, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.ID, ProfileField.HEADLINE), EnumSet.of(FacetField.NAME, FacetField.CODE, FacetField.BUCKET_NAME, FacetField.BUCKET_CODE, FacetField.BUCKET_COUNT), facets);
                printResult(people.getPeople());
                printResult(people.getFacets());
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
