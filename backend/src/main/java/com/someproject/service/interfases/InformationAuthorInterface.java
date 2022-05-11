package com.someproject.service.interfases;

import com.someproject.dto.InformationAuthorDTO;
import com.someproject.model.Author;
import com.someproject.model.Information;
import com.someproject.repository.InformationRepository;

import java.util.List;

public interface InformationAuthorInterface {

    Object addInformation(Information information);
    List<Information> findAllInformation();
    String deleteInformationById(Long id);

    Object addAuthor(Author author);
    List<Author> findAllAuthors();
    String deleteAuthorById(Long id);

    Object converterDtoToEntity(InformationAuthorDTO informationAuthorDTO);
}
