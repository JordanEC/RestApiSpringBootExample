package com.jordanec.restbootexample;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.jordanec.restbootexample.client.ConfederationApi;
import com.jordanec.restbootexample.model.Confederation;
import com.jordanec.restbootexample.model.Country;
import com.jordanec.restbootexample.model.Status;

import retrofit.Call;
import retrofit.Retrofit;

public class ConfederationTest {
	private ConfederationApi confederationApi;
	
	private static ConfederationTest confederationTest;
	
	protected ConfederationTest() {}
	
	   public static ConfederationTest getInstance(ConfederationApi confederationApi) {
	      if(confederationTest == null) {
	    	confederationTest = new ConfederationTest();
	    	confederationTest.setConfederationApi(confederationApi);
	      }
	      return confederationTest;
	   }
	   public static ConfederationTest getInstance(){
		   return confederationTest;
	   }

	public Confederation confederationReadTest(int idConfederation) {
		//System.out.println("\n\nconfederationReadTest...\n\n");
		Call<Confederation> call = confederationApi.readConfederation(idConfederation);

		try {
			retrofit.Response<Confederation> response = call.execute();
			if (response.isSuccess()) {
				Confederation confederation = response.body();
				System.out.println("idConfederation: " + confederation.getIdConfederation() + " name:"
						+ confederation.getName());
				return confederation;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private boolean confederationCreateTest() {
		Confederation confederation = new Confederation("Antártida_Created");
		System.out.println("\n\nconfederationCreateTest...\n\n");
		Call<Status> call = confederationApi.createConfederation(confederation);

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

	private boolean confederationUpdateTest(int idConfederation) {
		System.out.println("\n\nconfederationUpdateTest...\n\n");
		Confederation confederation = confederationReadTest(idConfederation);
		confederation.setName("Antártida_Updated");
		
		Call<Status> call = confederationApi.updateConfederation(confederation, idConfederation);

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

	private boolean confederationDeleteTest(int idConfederation) {
		System.out.println("\n\nconfederationDeleteTest...\n\n");
		Call<Status> call = confederationApi.deleteConfederation(7);

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

	public boolean confederationListTest() {
		System.out.println("\n\nconfederationListTest...\n\n");
		Call<Collection<Confederation>> call = confederationApi.listConfederations();

		try {
			retrofit.Response<Collection<Confederation>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Confederation> confederations = response.body();
				Iterator<Confederation> iterator = confederations.iterator();
				Confederation confederation;
				while (iterator.hasNext()) {
					confederation = iterator.next();
					System.out.println("idConfederation" + confederation.getIdConfederation() + " name:"
							+ confederation.getName());
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

	public boolean confederationFindByNameTest(String name) {
		System.out.println("\n\nFindByNameTest...\n\n");
		Call<Confederation> call = confederationApi.findByName(name);

		try {
			retrofit.Response<Confederation> response = call.execute();
			if (response.isSuccess()) {
				Confederation confederation = response.body();
				System.out.println("idConfederation: " + confederation.getIdConfederation() + " name:"
						+ confederation.getName());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public Collection<Country> confederationCountriesReadTest(int idConfederation) {
		System.out.println("\n\nconfederationCountriesReadTest...\n\n");
		Call<Collection<Country>> call = confederationApi.readConfederationCountries(idConfederation);

		try {
			retrofit.Response<Collection<Country>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Country> confederationCountries = response.body();
				System.out.println("idConfederation: "+idConfederation);
				
				Iterator<Country> iterator = confederationCountries.iterator();
				Country country;
				while (iterator.hasNext()) {
					country = iterator.next();
					System.out.println("idCountry: "+country.getIdCountry()+" name:"+country.getName());
				}
				
				return confederationCountries;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public boolean doAllTests() {
		if(/*confederationCreateTest() && */confederationReadTest(56) != null &&	//id1
		   /*confederationUpdateTest(7)  && confederationListTest() &&*/
		   confederationFindByNameTest("Antártida_Updated___")/* &&	confederationDeleteTest(7) &&
		   confederationCountriesReadTest(1) != null*/) {
			System.out.println("confederation tests successful! ");
			return true;
		}
		else {
			System.out.println("Error in confederation tests");
			return false;
		}
	}
	
	
	public ConfederationApi getConfederationApi() {
		return confederationApi;
	}

	public void setConfederationApi(ConfederationApi confederationApi) {
		this.confederationApi = confederationApi;
	}	
}
