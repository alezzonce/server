package com.sismed.server.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.sismed.server.utils.Pagination;
import com.sismed.server.respositories.InvoiceRepository;
import org.springframework.data.domain.PageRequest;

import com.sismed.server.entities.InvoiceEntity;

@Service
public class InvoiceService extends RuntimeException {

    @Autowired InvoiceRepository invoiceRepository;

    public Pagination<InvoiceEntity> getAllUsers(int page, int size){
        Page<InvoiceEntity> users = invoiceRepository.findAll(PageRequest.of(page, size));
        Pagination<InvoiceEntity> pagination = new Pagination<InvoiceEntity>();
        pagination.setCurrentPage(page);
        pagination.setData(users.getContent());
        pagination.setPageSize(size);
        pagination.setTotal(users.getTotalPages());
        pagination.setTotalElements(users.getTotalElements());
        pagination.setPage(users.getNumber());
        return pagination;
    }

    public InvoiceEntity createInvoice (InvoiceEntity invoiceEntity) {

        return invoiceRepository.save(invoiceEntity);
    }

    public InvoiceEntity updateInvoice (UUID id, InvoiceEntity user) {
        Optional<InvoiceEntity> InvoiceTypeUpdate = invoiceRepository.findById(id);
        if (InvoiceTypeUpdate.isPresent()) {
            InvoiceTypeUpdate.get().setAmount(user.getAmount());
            InvoiceTypeUpdate.get().setExpeditionDate(user.getExpeditionDate());
            return invoiceRepository.save(InvoiceTypeUpdate.get());
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }

    public InvoiceEntity deleteById (UUID id) {
        Optional<InvoiceEntity> userDelete = invoiceRepository.findById(id);
        if (userDelete.isPresent()) {
            invoiceRepository.deleteById(id);
            return userDelete.get();
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }
}