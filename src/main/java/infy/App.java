package infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan(basePackages= {"infy2", "infy1","dao"})
public class App extends SpringBootServletInitializer
{
public static void main( String[] args )
{
SpringApplication.run(App.class, args);
}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder app)
//	{
//		return app.sources(App.class);
//	}

}
