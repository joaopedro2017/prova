/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rio.puc.inf.les.model;

import br.rio.puc.inf.les.dao.CategoriaDAO;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tassio
 */
public class ReservasTest {

    public ReservasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCamaNormal() {
        System.out.println("Quantidade Limite");

        Categoria cat = new Categoria();
        cat.setCodigoCategoria(100);
        cat.setTipoCategoria("Standard");
        cat.setValorDiaria((float) 268.00);
        cat.setCapacidade(2);

        Apartamento apartamento = new Apartamento();
        apartamento.setIdApartamento(11);
        apartamento.setCodigoApartamento(100);
        apartamento.setCategoriacodigoCategoria(cat);

        Reservas reserva = new Reservas();
        reserva.setNumeroHospedes(2);
        reserva.setApartamentocodigoApartamento(apartamento);

        Double expResult = 268.00;
        Double result = reserva.camaExtra(reserva);
        assertEquals(expResult, result);
    }

    @Test
    public void testCamaExtra() {
        System.out.println("Mais Uma Cama Extra");

        Categoria cat = new Categoria();
        cat.setCodigoCategoria(100);
        cat.setTipoCategoria("Standard");
        cat.setValorDiaria((float) 268.00);
        cat.setCapacidade(2);

        Apartamento apartamento = new Apartamento();
        apartamento.setIdApartamento(11);
        apartamento.setCodigoApartamento(100);
        apartamento.setCategoriacodigoCategoria(cat);

        Reservas reserva = new Reservas();
        reserva.setNumeroHospedes(3);
        reserva.setApartamentocodigoApartamento(apartamento);

        Double expResult = 348.40000000000003;
        Double result = reserva.camaExtra(reserva);
        assertEquals(expResult, result);
    }

    @Test
    public void testCamaInvalida() {
        System.out.println("Quantidade de Hospedes no quarto invalido");

        Categoria cat = new Categoria();
        cat.setCodigoCategoria(100);
        cat.setTipoCategoria("Standard");
        cat.setValorDiaria((float) 268.00);
        cat.setCapacidade(2);

        Apartamento apartamento = new Apartamento();
        apartamento.setIdApartamento(11);
        apartamento.setCodigoApartamento(100);
        apartamento.setCategoriacodigoCategoria(cat);

        Reservas reserva = new Reservas();
        reserva.setNumeroHospedes(4);
        reserva.setApartamentocodigoApartamento(apartamento);

        Double expResult = 0.0;
        Double result = reserva.camaExtra(reserva);
        assertEquals(expResult, result);
    }

    @Test
    public void testOcupacao1() {
        System.out.println("Ocupação 1");

        Date hoje = new Date();
        Date futuro = new Date(+2);

        Categoria cat = new Categoria();
        cat.setCodigoCategoria(1);
        cat.setTipoCategoria("Standard");
        cat.setValorDiaria((float) 268.00);
        cat.setCapacidade(2);

        Apartamento apartamento = new Apartamento();
        apartamento.setIdApartamento(1);
        apartamento.setCodigoApartamento(1);
        apartamento.setCategoriacodigoCategoria(cat);

        Usuarios usuario = new Usuarios();
        usuario.setCodUsuario(101);
        usuario.setNomeUsuario("Reginaldo Farias");
        usuario.setContatoUsuario("(51) 96186617");

        Reservas reserva = new Reservas();
        reserva.setUsuarioscodUsuario(usuario);
        reserva.setNumeroHospedes(3);
        reserva.setDataEntrada(hoje);
        reserva.setDataSaida(futuro);
        reserva.setApartamentocodigoApartamento(apartamento);

        Double expResult = 348.40000000000003;
        Double result = reserva.camaExtra(reserva);

        assertEquals(expResult, result);

    }

    @Test
    public void testOcupacao2() {
        System.out.println("Ocupação 2");

        Date ontem = new Date(-1);
        Date futuro = new Date(+3);

        Categoria cat = new Categoria();
        cat.setCodigoCategoria(4);
        cat.setTipoCategoria("Apartamento Vista Bosque");
        cat.setValorDiaria((float) 315.00);
        cat.setCapacidade(4);

        Apartamento apartamento = new Apartamento();
        apartamento.setIdApartamento(4);
        apartamento.setCodigoApartamento(4);
        apartamento.setCategoriacodigoCategoria(cat);

        Usuarios usuario = new Usuarios();
        usuario.setCodUsuario(101);
        usuario.setNomeUsuario("Reginaldo Farias");
        usuario.setContatoUsuario("(51) 96186617");

        Reservas reserva = new Reservas();
        reserva.setUsuarioscodUsuario(usuario);
        reserva.setNumeroHospedes(4);
        reserva.setDataEntrada(ontem);
        reserva.setDataSaida(futuro);
        reserva.setApartamentocodigoApartamento(apartamento);

        Double expResult = 315.00;
        Double result = reserva.camaExtra(reserva);
        assertEquals(expResult, result);

    }

    @Test
    public void testReserva() {
        System.out.println("Reserva");

        Date dia1 = new Date(+5);
        Date dia2 = new Date(+7);

        Categoria cat = new Categoria();
        cat.setCodigoCategoria(4);
        cat.setTipoCategoria("Suíte");
        cat.setValorDiaria((float) 498.00);
        cat.setCapacidade(2);

        Apartamento apartamento = new Apartamento();
        apartamento.setIdApartamento(110);
        apartamento.setCodigoApartamento(10);
        apartamento.setCategoriacodigoCategoria(cat);

        Usuarios usuario = new Usuarios();
        usuario.setCodUsuario(103);
        usuario.setNomeUsuario("Augusto Santos");
        usuario.setContatoUsuario("(81) 92097644");

        Reservas reserva = new Reservas();
        reserva.setUsuarioscodUsuario(usuario);
        reserva.setNumeroHospedes(2);
        reserva.setDataEntrada(dia1);
        reserva.setDataSaida(dia2);
        reserva.setApartamentocodigoApartamento(apartamento);

        Double expResult = 498.00;
        Double result = reserva.camaExtra(reserva);

        assertEquals(expResult, result);

    }

}
