package hu.javagladiators.apps.heroesofempires.hero.service_memory;

import hu.javagladiators.apps.heroesofempires.basic.BussinessError;
import hu.javagladiators.apps.heroesofempires.hero.model.Hero;

/**
 * @author krisztian
 */
public class HeroError extends BussinessError<Hero>{

    public HeroError(String code, String message, Hero hero, String property, Exception exception) {
        this.code = code;
        this.message = message;
        this.exception = exception;
        this.data = hero;
        this.property = property;
    }
    
}
