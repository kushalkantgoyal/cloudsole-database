package com.example.dao;

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
