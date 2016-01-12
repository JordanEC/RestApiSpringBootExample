package com.jordanec.restbootexample;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.jordanec.restbootexample.client.ConfederacionApi;
import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.model.Pais;
import com.jordanec.restbootexample.model.Status;

import retrofit.Call;
import retrofit.Retrofit;

public class ConfederacionTest {
	private ConfederacionApi confederacionApi;
	
	private static ConfederacionTest confederacionTest;
	
	protected ConfederacionTest() {}
	
	   public static ConfederacionTest getInstance(ConfederacionApi confederacionApi) {
	      if(confederacionTest == null) {
	    	confederacionTest = new ConfederacionTest();
	    	confederacionTest.setConfederacionApi(confederacionApi);
	      }
	      return confederacionTest;
	   }
	   public static ConfederacionTest getInstance(){
		   return confederacionTest;
	   }


	public Confederacion confederacionReadTest(int idConfederacion) {
		//System.out.println("\n\nconfederacionReadTest...\n\n");
		Call<Confederacion> call = confederacionApi.readConfederacion(idConfederacion);

		try {
			retrofit.Response<Confederacion> response = call.execute();
			if (response.isSuccess()) {
				Confederacion confederacion = response.body();
				System.out.println("idConfederacion: " + confederacion.getIdConfederacion() + " nombre:"
						+ confederacion.getNombre());
				return confederacion;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean confederacionCreateTest() {
		Confederacion confederacion = new Confederacion("Antártida_Created");
		System.out.println("\n\nconfederacionCreateTest...\n\n");
		Call<Status> call = confederacionApi.createConfederacion(confederacion);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println("response.message()=" + response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean confederacionUpdateTest(int idConfederacion) {
		System.out.println("\n\nconfederacionUpdateTest...\n\n");
		Confederacion confederacion = confederacionReadTest(idConfederacion);
		confederacion.setNombre("Antártida_Updated");
		
		Call<Status> call = confederacionApi.updateConfederacion(confederacion, idConfederacion);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean confederacionDeleteTest(int idConfederacion) {
		System.out.println("\n\nconfederacionDeleteTest...\n\n");
		Call<Status> call = confederacionApi.deleteConfederacion(7);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean confederacionListTest() {
		System.out.println("\n\nconfederacionListTest...\n\n");
		Call<Collection<Confederacion>> call = confederacionApi.listConfederaciones();

		try {
			retrofit.Response<Collection<Confederacion>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Confederacion> confederaciones = response.body();
				Iterator<Confederacion> iterator = confederaciones.iterator();
				Confederacion confederacion;
				while (iterator.hasNext()) {
					confederacion = iterator.next();
					System.out.println("idConfederacion" + confederacion.getIdConfederacion() + " nombre:"
							+ confederacion.getNombre());
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

	public boolean confederacionFindByNameTest(String nombre) {
		System.out.println("\n\nFindByNameTest...\n\n");
		Call<Confederacion> call = confederacionApi.findByNombre(nombre);

		try {
			retrofit.Response<Confederacion> response = call.execute();
			if (response.isSuccess()) {
				Confederacion confederacion = response.body();
				System.out.println("idConfederacion: " + confederacion.getIdConfederacion() + " nombre:"
						+ confederacion.getNombre());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public Collection<Pais> confederacionPaisesReadTest(int idConfederacion) {
		System.out.println("\n\nconfederacionPaisesReadTest...\n\n");
		Call<Collection<Pais>> call = confederacionApi.readConfederacionPaises(idConfederacion);

		try {
			retrofit.Response<Collection<Pais>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Pais> confederacionPaises = response.body();
				System.out.println("idConfederacion: "+idConfederacion);
				
				Iterator<Pais> iterator = confederacionPaises.iterator();
				Pais pais;
				while (iterator.hasNext()) {
					pais = iterator.next();
					System.out.println("idPais: "+pais.getIdPais()+" nombre:"+pais.getNombre());
				}
				
				return confederacionPaises;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public boolean doAllTests() {
		if(confederacionCreateTest() && confederacionReadTest(1) != null &&
		   confederacionUpdateTest(7)  && confederacionListTest() &&
		   confederacionFindByNameTest("Antártida_Updated") &&	confederacionDeleteTest(7) &&
		   confederacionPaisesReadTest(1) != null) {
			System.out.println("confederacion tests successful! ");
			return true;
		}
		else {
			System.out.println("Error in confederacion tests");
			return false;
		}
	}
	
	
	public ConfederacionApi getConfederacionApi() {
		return confederacionApi;
	}

	public void setConfederacionApi(ConfederacionApi confederacionApi) {
		this.confederacionApi = confederacionApi;
	}	
}
