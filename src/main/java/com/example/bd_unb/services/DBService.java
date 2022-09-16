package com.example.bd_unb.services;//package com.example.bd_unb.services;

import java.util.Arrays;

import com.example.bd_unb.domain.*;
import com.example.bd_unb.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private AtorRepository atorRepository;

    @Autowired
    private EstudioRepository estudioRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public void instantiateTestDataBase() {

    }

}
