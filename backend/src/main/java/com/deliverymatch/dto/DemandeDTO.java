package com.deliverymatch.dto;


import com.deliverymatch.model.Annonce;
import com.deliverymatch.model.DemandeStatus;

import java.util.Date;
import java.util.List;

public record DemandeDTO (
        Long id,
        Date date,
        String status,
        Long expediteurId,
        Long annonceId,
        List<ColisDTO> colis
) { }








