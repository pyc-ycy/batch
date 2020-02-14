//IntelliJ IDEA
//batch
//CsvBatchConfig
//2020/2/14
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.batch.mybatch;

import com.pyc.batch.domain.Person;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class CsvBatchConfig {

    @Bean
    public ItemReader<Person> reader() throws Exception {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("people.csv"));
        reader.setLineMapper(new DefaultLineMapper<Person>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {{
                    setNames(new String[]{"name", "age", "nation", "address"});
                }});
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){{
                    setTargetType(Person.class);
                }});
            }});
        return reader;
    }

    @Bean
    public Validator<Person> csvBeanValidator(){
        return new CsvBeanValidator<Person>();
    }

    @Bean
    public CsvJobListener csvJobListener(){
        return new CsvJobListener();
    }

    @Bean
    public ItemProcessor<Person,Person> processor(){
        CsvItemProcessor processor = new CsvItemProcessor();
        processor.setValidator(csvBeanValidator());
        return processor;
    }


}
