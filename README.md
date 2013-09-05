# CloudSole Database

    Spring Data
    Spring MVC
    JPA
    Hibernate
    Redis
    Oracle
    REST
    Quartz
    
#Annotation Context
    <?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
                        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd">
    
    <context:annotation-config />
    <context:component-scan base-package="com.example.hibernate" />
    
	<!--  <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/servicecore"/>
		<property name="username" value="root"/>
		<property name="password" value=""/>
	</bean>-->
	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/servicecore"/>
		<property name="username" value="root"/>
		<property name="password" value=""/>
		<property name="initialSize" value="2"/>
		<property name="maxActive" value="5"/>
	</bean>
	
	<bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="packagesToScan" value="com.example.model"/>
		<property name="hibernateProperties">
			<props>
				<prop key="dialect">org.hibernate.dialect.MySQLDialect</prop>
			</props>
		</property>
	
	</bean>
</beans>
    
    
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
                        	http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd">
    
	 <context:annotation-config />
    	<context:component-scan base-package="com.example.jdbc" />
    
		<!--  <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
			<property name="driverClassName" value="com.mysql.jdbc.Driver" />
			<property name="url" value="jdbc:mysql://localhost:3306/servicecore"/>
			<property name="username" value="root"/>
			<property name="password" value=""/>
		</bean>-->
	
		<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
			<property name="driverClassName" value="com.mysql.jdbc.Driver" />
			<property name="url" value="jdbc:mysql://localhost:3306/servicecore"/>
			<property name="username" value="root"/>
			<property name="password" value=""/>
			<property name="initialSize" value="2"/>
			<property name="maxActive" value="5"/>
		</bean>
	
	</beans>
    
#Jdbc
    	package com.example.jdbc;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import javax.sql.DataSource;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.RowMapper;
	import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
	import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
	import org.springframework.jdbc.core.namedparam.SqlParameterSource;
	import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
	import org.springframework.stereotype.Component;

	import com.example.model.Customer;

	@Component(value="JdbcDaoImpl")
	public class JdbcDoaImpl {
	
		private DataSource dataSource;
		private JdbcTemplate jdbcTemplate;
		private NamedParameterJdbcTemplate namedparmjdbtemp;
		
		public static Connection setupJdbcConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			Connection connection = null;
		
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servicecore","root", "");
			return connection;
		}
	
		public Customer getCustomer(int customerId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
			Connection connection = dataSource.getConnection();
			java.sql.PreparedStatement ps = connection.prepareStatement("Select * from customer where id=?");
			ps.setInt(1, customerId);
		
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				customer = new Customer(customerId, rs.getString("first_name"), rs.getString("last_name"));
			}
			rs.close();
			ps.close();
			connection.close();
			return customer;
		}
	
		public int getCustomerCount(){
			//jdbcTemplate.setDataSource(getDataSource());
			return jdbcTemplate.queryForInt("Select count(*) from customer");
		}
	
		public String getCustomerFName(long id){
			String sql = "Select first_name from customer where id = ?";
			return jdbcTemplate.queryForObject(sql, new Object[]{id},String.class);
		}
	
		public Customer getCustomerForId(long id){
			String sql = "Select * from customer where id = ?";
			return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerMapper());
		}
	
		public List<Customer> getListCustomers(){
			String sql = "Select id, first_name, last_name from customer";
			return jdbcTemplate.query(sql, new CustomerMapper());
		}
	
		public void insertCustomer(Customer customer){
			String sql = "Insert into customer(first_name, last_name) values(?,?)";
			jdbcTemplate.update(sql, new Object[]{customer.getFirstName(), customer.getLastName()});
		}
	
		public void insertCustomerNP(Customer customer){
			String sql = "Insert into customer(first_name, last_name) values(:fname,:lname)";
			SqlParameterSource namedParm = new MapSqlParameterSource("fname", customer.getFirstName()).addValue("lname", customer.getLastName());
			namedparmjdbtemp.update(sql, namedParm);
		
			//jdbcTemplate.update(sql, new Object[]{customer.getFirstName(), customer.getLastName()});
		}
	
		public void createLeadTable(){
			String sql = "Create table lead (id integer, name varchar(255))";
			jdbcTemplate.execute(sql);
		}
	
		public static final class CustomerMapper implements RowMapper<Customer>{
			@Override
			public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setId(resultSet.getLong("id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				return customer;
			}
		}
	
		public List<Customer> getAllCustomers(){
			return null;
		}
	
		public DataSource getDataSource() {
			return dataSource;
		}
	
		@Autowired
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.namedparmjdbtemp = new NamedParameterJdbcTemplate(dataSource);
		}
	
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
	}
    
#Main

	package com.example.jdbc;

	import java.sql.SQLException;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	import com.example.model.Customer;

	public class MainConfig {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(JdbcDoaImpl.class.getPackage().getName());
        applicationContext.refresh();*/
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/jdbcContext.xml");
		JdbcDoaImpl jdbcdao = ctx.getBean("JdbcDaoImpl", JdbcDoaImpl.class);
		
       // JdbcDoaImpl jdbcdao = applicationContext.getBean(JdbcDoaImpl.class);
		//Customer customer = jdbcdao.getCustomer(14);
		//System.out.println(customer.getFirstName());
		//System.out.println(jdbcdao.getCustomerCount());
		//System.out.println(jdbcdao.getCustomerFName(14));
		//System.out.println(jdbcdao.getCustomerForId(14));
		//System.out.println(jdbcdao.getAllCustomers().size());
		
		jdbcdao.insertCustomerNP(new Customer("sd", "asd"));
		//jdbcdao.createLeadTable();
		
	}
	}

    
    

    
