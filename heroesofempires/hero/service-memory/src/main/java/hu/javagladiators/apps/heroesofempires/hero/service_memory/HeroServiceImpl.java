package hu.javagladiators.apps.heroesofempires.hero.service_memory;

import hu.javagladiators.apps.heroesofempires.basic.DataAccessException;
import hu.javagladiators.apps.heroesofempires.hero.model.Hero;
import hu.javagladiators.apps.heroesofempires.hero.model.HeroService;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.dozer.Mapper;


/**
 * statikus memori alapu implementacio
 * @author krisztian
 */
public class HeroServiceImpl implements HeroService{
    
    private static final List<Hero> data = new CopyOnWriteArrayList<>();

    @Override
    public void add(Hero pValue) {
        data.add(pValue);
    }

    @Override
    public Hero getByKey(String pName) {
        for(Hero tmp: data)
            if(tmp.getName().equals(pName))
                return tmp;
        throw new DataAccessException("Not exist:"+pName);
    }

    @Override
    public List<Hero> getMoreOrderByKey(int pOffset, long pLimit) {
        int min = 0;
        int max = (int)getSize();
        if(pOffset>0) min = pOffset;
        if(pOffset+pLimit < max) max = (int)(pOffset+pLimit);
        if(pLimit<0) max =min;
        return data.subList(min, max);
    }

    @Override
    public void deleteByKey(String pName) {
        for(Hero tmp: data)
            if(tmp.getName().equals(pName))
                data.remove(tmp);
    }

    @Override
    public long getSize() {
        return data.size();
    }

    @Override
    public void modify(String pOldKey, Hero pNewValue) {
        for(Hero tmp: data)
            if(tmp.getName().equals(pOldKey)){
                tmp.setName(pNewValue.getName());
                tmp.setDescription(pNewValue.getDescription());
                tmp.setAvailable(pNewValue.isAvailable());
            }
    }
    
}
