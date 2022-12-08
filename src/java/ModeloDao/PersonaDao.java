package ModeloDao;

import Config.Conexion;
import Interfaz.CRUD;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona per = new Persona();

    @Override
    public List listar() {
        ArrayList<Persona> list = new ArrayList();
        String sql = "select * from persona";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt("id"));
                p.setDni(rs.getString("Dni"));
                p.setNom(rs.getString("Nombres"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Persona list(int id) {
        String sql = "select * from persona where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                per.setId(rs.getInt("id"));
                per.setDni(rs.getString("Dni"));
                per.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return per;
    }

    @Override
    public boolean add(Persona per) {
        String sql = "insert into persona (Dni, Nombres)values('" + per.getDni() + "', '" + per.getNom() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql = "update persona set Dni='" + per.getDni() + "', Nombres= '" + per.getNom() + "'where id=" + per.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
          String sql = "delete from persona where id="+id;
          try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
          return false;
    }

}
