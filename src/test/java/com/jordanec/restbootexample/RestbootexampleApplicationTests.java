package com.jordanec.restbootexample;

import java.io.IOException;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import org.springframework.test.context.web.WebAppConfiguration;
import com.jordanec.restbootexample.client.ConfederacionApi;
import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.util.Status;

import retrofit.Call;
import retrofit.Retrofit;
import retrofit.JacksonConverterFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestbootexampleApplication.class)
@WebAppConfiguration
public class RestbootexampleApplicationTests {
	ConfederacionApi confederacionApi;

	@Test
	public void contextLoads() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080")
				.addConverterFactory(JacksonConverterFactory.create()).build();
		confederacionApi = retrofit.create(ConfederacionApi.class);

		assertTrue(createTest());
		assertTrue(readTest());
		assertTrue(findByNameTest());
		assertTrue(updateTest());
		assertTrue(listTest());
		assertTrue(deleteTest());
		

		/*
		 * call.enqueue(new Callback<Collection<Confederacion>>() {
		 * 
		 * @Override public void
		 * onResponse(retrofit.Response<Collection<Confederacion>> response,
		 * Retrofit retrofit) { if(response.isSuccess()) {
		 * Collection<Confederacion> confe = response.body();
		 * System.out.println(confe); } else {
		 * System.out.println("response.code()="+response.code());
		 * System.out.println("response.errorBody()="+response.errorBody()); }
		 * 
		 * }
		 * 
		 * @Override public void onFailure(Throwable t) {
		 * System.out.println(t.getMessage());
		 * 
		 * } });
		 */

	}

	private boolean createTest() {
		Confederacion confederacion = new Confederacion("Antártida");
		confederacion.setIdConfederacion(7);
		confederacion.setCantidadDePaises(1);
		
		Call<Status> call = confederacionApi.createConfederacion(confederacion);

		try {
			retrofit.Response<Status> response = call.execute();
			if(response.isSuccess()) {
				Status status = response.body();
				System.out.println("status.getCode()="+status.getCode()+"\nstatus.getMessage()="+status.getMessage());
				return true;
			}
			System.out.println("response.message()="+response.message());
			return false;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean readTest() {
		Call<Confederacion> call = confederacionApi.readConfederacion(5);
		
		try {
			retrofit.Response<Confederacion> response = call.execute();
			if(response.isSuccess()) {
				Confederacion confederacion = response.body();
				System.out.println(confederacion);
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean updateTest() {
		Confederacion confederacion = new Confederacion("Antártida_Updated");
		confederacion.setIdConfederacion(7);
		confederacion.setCantidadDePaises(5);
		
		Call<Status> call = confederacionApi.updateConfederacion(confederacion, 7);
		
		try {
			retrofit.Response<Status> response = call.execute();
			if(response.isSuccess()) {
				Status status = response.body();
				System.out.println("status.getCode()="+status.getCode()+"\nstatus.getMessage()="+status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean deleteTest() {
		Call<Status> call = confederacionApi.deleteConfederacion(7);
		
		try {
			retrofit.Response<Status> response = call.execute();
			if(response.isSuccess()) {
				Status status = response.body();
				System.out.println("status.getCode()="+status.getCode()+"\nstatus.getMessage()="+status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean listTest() {
		Call<Collection<Confederacion>> call = confederacionApi.listConfederaciones();

		try {
			retrofit.Response<Collection<Confederacion>> response = call.execute();
			if(response.isSuccess()) {
				Collection<Confederacion> confederaciones = response.body();
				System.out.println(confederaciones);
				return true;
			}
			System.out.println(response.message());
			return false;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean findByNameTest() {
		Call<Confederacion> call = confederacionApi.findByNombre("CONMEBOL");
		
		try {
			retrofit.Response<Confederacion> response = call.execute();
			if(response.isSuccess()) {
				Confederacion confederacion = response.body();
				System.out.println(confederacion);
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
