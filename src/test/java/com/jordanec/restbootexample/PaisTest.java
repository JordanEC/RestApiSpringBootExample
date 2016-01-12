package com.jordanec.restbootexample;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.jordanec.restbootexample.client.PaisApi;
import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.model.Equipo;
import com.jordanec.restbootexample.model.Jugador;
import com.jordanec.restbootexample.model.Pais;
import com.jordanec.restbootexample.model.Status;

import retrofit.Call;
import retrofit.Retrofit;

public class PaisTest {
	private PaisApi paisApi;

	private static PaisTest paisTest;

	protected PaisTest() {
	}

	public static PaisTest getInstance(PaisApi paisApi) {
		if (paisTest == null) {
			paisTest = new PaisTest();
			paisTest.setPaisApi(paisApi);
		}
		return paisTest;
	}

	public Pais paisReadTest(int idPais) {
		// System.out.println("\n\npaisReadTest...\n\n");
		Call<Pais> call = paisApi.readPais(idPais);

		try {
			retrofit.Response<Pais> response = call.execute();
			if (response.isSuccess()) {
				Pais pais = response.body();
				System.out.println("idPais: " + pais.getIdPais() + " nombre:" + pais.getNombre());
				return pais;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean paisCreateTest(int idConfederacion) {
		System.out.println("\n\npaisCreateTest...\n\n");
		Confederacion confederacion = ConfederacionTest.getInstance().confederacionReadTest(idConfederacion);
		Pais pais = new Pais(confederacion, "Panamá", 76);

		Call<Status> call = paisApi.createPais(pais);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println("status.getCode()=" + status.getCode() + pais.getNombre() + "\nstatus.getMessage()="
						+ status.getMessage());
				return true;
			}
			System.out.println("response.message()=" + response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean paisUpdateTest(int idPais) {
		System.out.println("\n\npaisUpdateTest...\n\n");
		Pais pais = paisReadTest(idPais);
		pais.setNombre(pais.getNombre() + "_Updated");

		Call<Status> call = paisApi.updatePais(pais, idPais);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println("status.getCode()=" + status.getCode() + pais.getNombre() + "\nstatus.getMessage()="
						+ status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean paisDeleteTest(int idPais) {
		System.out.println("\n\npaisDeleteTest...\n\n");
		Call<Status> call = paisApi.deletePais(idPais);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println("status.getCode()=" + status.getCode() + "idPais: " + idPais
						+ "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean paisListTest() {
		System.out.println("\n\npaisListTest...\n\n");
		Call<Collection<Pais>> call = paisApi.listPaises();

		try {
			retrofit.Response<Collection<Pais>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Pais> paises = response.body();
				Iterator<Pais> iterator = paises.iterator();
				Pais pais;
				while (iterator.hasNext()) {
					pais = iterator.next();
					System.out.println("idPais" + pais.getIdPais() + " nombre:" + pais.getNombre());
				}

				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean paisFindByNameTest(String nombre) {
		System.out.println("\n\nFindByNameTest...\n\n");
		Call<Pais> call = paisApi.findByNombre(nombre);

		try {
			retrofit.Response<Pais> response = call.execute();
			if (response.isSuccess()) {
				Pais pais = response.body();
				System.out.println("idPais: " + pais.getIdPais() + " nombre:" + pais.getNombre());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Collection<Equipo> paisEquiposReadTest(int idPais) {
		System.out.println("\n\npaisEquiposReadTest...\n\n");
		Call<Collection<Equipo>> call = paisApi.readPaisEquipos(idPais);

		try {
			retrofit.Response<Collection<Equipo>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Equipo> paisEquipos = response.body();
				System.out.println("idPais: " + idPais);

				Iterator<Equipo> iterator = paisEquipos.iterator();
				Equipo equipo;
				while (iterator.hasNext()) {
					equipo = iterator.next();
					System.out.println("idEquipo: " + equipo.getIdEquipo() + " nombre:" + equipo.getNombre());
				}

				return paisEquipos;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Collection<Jugador> paisJugadoresReadTest(int idPais) {
		System.out.println("\n\npaisJugadoresReadTest...\n\n");
		Call<Collection<Jugador>> call = paisApi.readPaisJugadores(idPais);

		try {
			retrofit.Response<Collection<Jugador>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Jugador> paisJugadores = response.body();
				System.out.println("idPais: " + idPais);

				Iterator<Jugador> iterator = paisJugadores.iterator();
				Jugador jugador;
				while (iterator.hasNext()) {
					jugador = iterator.next();
					System.out.println("idJugador: " + jugador.getIdJugador() + " nombre:" + jugador.getNombre());
				}

				return paisJugadores;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Confederacion paisConfederacionReadTest(int idPais) {
		System.out.println("\n\npaisConfederacionReadTest...\n\n");
		Call<Confederacion> call = paisApi.readPaisConfederacion(idPais);

		try {
			retrofit.Response<Confederacion> response = call.execute();
			if (response.isSuccess()) {
				Confederacion paisConfederacion = response.body();
				System.out.println("idConfederacion: " + paisConfederacion.getIdConfederacion() + " nombre:"
						+ paisConfederacion.getNombre());
				return paisConfederacion;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean doAllTests() {
		if (paisCreateTest(1) && paisReadTest(1) != null && paisUpdateTest(18) && paisListTest()
				&& paisFindByNameTest("Panamá_Updated") && paisDeleteTest(18) && paisEquiposReadTest(1) != null
				&& paisJugadoresReadTest(1) != null && paisConfederacionReadTest(1) != null) {
			System.out.println("pais tests successful! ");
			return true;
		} else {
			System.out.println("Error in pais tests");
			return false;
		}
	}

	public PaisApi getPaisApi() {
		return paisApi;
	}

	public void setPaisApi(PaisApi paisApi) {
		this.paisApi = paisApi;
	}

}
