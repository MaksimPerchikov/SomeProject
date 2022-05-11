package com.someproject.service;

import com.someproject.dto.InformationAuthorDTO;
import com.someproject.model.Author;
import com.someproject.model.Information;
import com.someproject.repository.AuthorRepository;
import com.someproject.repository.InformationRepository;
import com.someproject.service.interfases.InformationAuthorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInformationImpl implements InformationAuthorInterface {

    private final InformationRepository informationRepository;
    private final AuthorRepository authorRepository;
    @Autowired
    public ServiceInformationImpl(InformationRepository informationRepository,
                                  AuthorRepository authorRepository){
        this.informationRepository = informationRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public Object addInformation(Information information) {
        try {
            informationRepository.save(information);
            return "Добавление прошло успешно!"+findAllInformation();
        }catch (Exception e){
            return "Добавление не произошло!Причины: "+e.getMessage();
        }
    }

    @Override
    public List<Information> findAllInformation() {
        return informationRepository.findAll();
    }

    @Override
    public String deleteInformationById(Long id) {
        return null;
    }

    @Override
    public Object addAuthor(Author author) {
        try {
            authorRepository.save(author);
            return "Добавление прошло успешно!"+findAllAuthors();
        }catch (Exception e){
            return "Добавление не произошло!Причины: "+e.getMessage();
        }
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public String deleteAuthorById(Long id) {
        return null;
    }

    @Override
    public Object converterDtoToEntity(InformationAuthorDTO informationAuthorDTO) {
        return null;
    }
}
