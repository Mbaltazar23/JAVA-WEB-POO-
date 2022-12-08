/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Modelo.Persona;
import java.util.List;

public interface CRUD {

    public List listar();

    public Persona list(int id);

    public boolean add(Persona per);

    public boolean edit(Persona per);

    public boolean eliminar(int id);
}
