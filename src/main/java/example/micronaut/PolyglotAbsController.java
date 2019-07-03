package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/abs") 
public class PolyglotAbsController {

    private final PolyglotAbsService  polyglotAbsService;

    public PolyglotAbsController(PolyglotAbsService polyglotAbsService) { 
        this.polyglotAbsService = polyglotAbsService;
    }

    @Get("/java")
    public String javaAbs() {
        return polyglotAbsService.javaAbs(-99);
    }

    @Get("/ruby")     
    public String rubyAbs() {
        return polyglotAbsService.rubyAbs(-99);
    }
}
