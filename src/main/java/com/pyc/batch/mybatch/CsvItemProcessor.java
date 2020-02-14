//IntelliJ IDEA
//batch
//CsvItemProcessor
//2020/2/14
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.batch.mybatch;

import com.pyc.batch.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

public class CsvItemProcessor extends ValidatingItemProcessor<Person> {
    @Override
    public Person process(Person item) throws ValidationException {
        super.process(item);
        if(item.getNation().equals("汉族")){
            item.setNation("01");
        }else {
            item.setNation("02");
        }
        return item;
    }
}
