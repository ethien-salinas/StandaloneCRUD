package com.ethien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ethien.config.DBConfiguration;
import com.ethien.model.Persona;

public class PersonaDAOImpl implements PersonaDAO {

	/**
	 * CREATE TABLE IF NOT EXISTS PERSONA (id, nombre, apellido, direccion, ciudad)*
	 * */
	@Override
	public void createTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBConfiguration.getConnection();
			statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS PERSONA "
					+ "(id int primary key IDENTITY,"
					+ "nombre varchar(255), " 
					+ "apellido varchar(255), "
					+ "direccion varchar(255), " 
					+ "ciudad varchar(255))");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Operación Create del CRUD
	 * esta operación es identificada como "save" o "insert" en POO
	 */
	public void create(Persona persona) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String statement = "INSERT INTO persona "
        		+ "(nombre,apellido, direccion, ciudad) "
        		+ "VALUES (?, ?, ?, ?)";
        try {
            connection = DBConfiguration.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
            preparedStatement.setString(3, persona.getDireccion());
            preparedStatement.setString(4, persona.getCiudad());
            preparedStatement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	/**
	 * Operación Read del CRUD
	 * esta operación es identificada como "get" en POO
	 */
	public Persona read(int id) {
		Persona person = new Persona();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "SELECT * FROM PERSONA WHERE id = ?";
        try {
            connection = DBConfiguration.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                person.setId(resultSet.getInt("id"));
                person.setNombre(resultSet.getString("nombre"));
                person.setApellido(resultSet.getString("apellido"));
                person.setDireccion(resultSet.getString("direccion"));
                person.setCiudad(resultSet.getString("ciudad"));
            }
            //System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return person;
	}

	/**
	 * Operación Update del CRUD
	 * esta operación es realizada como "set" -> "save" en POO
	 */
	public void update(int id, Persona persona) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String statement = "UPDATE PERSONA SET " + 
                    "nombre = ?, apellido = ?, direccion = ?, ciudad = ?" + 
                    " WHERE id = ?";
        try {
            connection = DBConfiguration.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
            preparedStatement.setString(3, persona.getDireccion());
            preparedStatement.setString(4, persona.getCiudad());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	/**
	 * Operación Delete del CRUD
	 * esta operación es conocida como "remove" o "delete" en POO
	 */
	public void delete(int id) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String statement = "DELETE FROM PERSONA WHERE id = ?";
        try {
            connection = DBConfiguration.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	public List<Persona> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
