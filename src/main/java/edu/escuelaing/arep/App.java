package edu.escuelaing.arep;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        port(getPort());
        get("/", (req, res) -> {
            Double number = Double.parseDouble(req.queryParams("value"));
            String function = req.queryParams("Operation");
            String url= "https://thawing-earth-58973.herokuapp.com/?value="+number+"&Operation="+function;
            return Fachada.direccion(url);
        });
    }

    /**
     * Metedo getPort se encarga de obtener el puerto para ejecutar localmente.
     * @return 4567 Puerto para ejecutar localmente
     **/
    static int getPort() {
        if (System.getenv("PORT") != null) {

            return Integer.parseInt(System.getenv("PORT"));
        }
        return 1234;
    }
}
