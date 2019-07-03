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
    public String test() {
        return "test success";
    }

    @Get("/js") 
    public String jsAbs() { 
        return polyglotAbsService.jsAbs(-42);
    }

    @Get("/python")     
    public String pyAbs() {
        return polyglotAbsService.pyAbs(-42);
    }

    @Get("/ruby")     
    public String rbAbs() {
        return polyglotAbsService.rbAbs(-42);
    }
}
