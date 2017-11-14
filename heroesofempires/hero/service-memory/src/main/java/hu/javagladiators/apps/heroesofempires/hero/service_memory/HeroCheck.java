package hu.javagladiators.apps.heroesofempires.hero.service_memory;

import hu.javagladiators.apps.heroesofempires.basic.BussinessError;
import hu.javagladiators.apps.heroesofempires.hero.model.Hero;
import java.util.ArrayList;
import java.util.List;

/**
 * ellenőrzések
 * @author krisztian
 */
public class HeroCheck {
    private List<BussinessError<Hero>> errors = new ArrayList<>();
    
    public static HeroCheck newInstance(){
        return new HeroCheck();
    }
    
    public HeroCheck nameIsExist(Hero pHero){
        return this;
    }

    public HeroCheck nameIsNotExist(){
        return this;
    }
    
    public boolean isError(){return errors.size()>0;}
    
    public List<BussinessError<Hero>> build(){return errors;}
}
