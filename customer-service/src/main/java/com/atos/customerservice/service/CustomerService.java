package com.atos.customerservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atos.cutomerservice.dto.CustomerDTO;

public interface CustomerService {

	/**
	 * Ajoute un nouveau client.
	 *
	 * @param customerDTO DTO du client à créer
	 * @return DTO du client créé
	 */
	CustomerDTO addCustomer(CustomerDTO customerDTO);

	/**
	 * Met à jour un client existant.
	 *
	 * @param customerId  ID du client à mettre à jour
	 * @param customerDTO DTO contenant les nouvelles informations
	 * @return DTO du client mis à jour
	 */
	CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO);

	/**
	 * Supprime un client par son ID.
	 *
	 * @param customerId ID du client à supprimer
	 */
	void deleteCustomer(Long customerId);

	/**
	 * Retourne un client par son ID.
	 *
	 * @param customerId ID du client à rechercher
	 * @return Optional contenant le client s'il existe
	 */
	CustomerDTO findCustomerById(Long customerId);

	/**
	 * Retourne tous les clients avec pagination.
	 *
	 * @param pageable Paramètres de pagination
	 * @return Page de DTO clients
	 */
	Page<CustomerDTO> findAllCustomers(Pageable pageable);

	/**
	 * Recherche des clients selon des critères flexibles avec pagination.
	 *
	 * @param firstName   prénom du client (optionnel)
	 * @param lastName    nom du client (optionnel)
	 * @param email       email du client (optionnel)
	 * @param dateOfBirth date de naissance (optionnel)
	 * @param pageable    paramètres de pagination
	 * @return Page de DTO clients correspondant aux critères
	 */
	Page<CustomerDTO> searchCustomers(String firstName, String lastName, String email, LocalDate dateOfBirth,
			Pageable pageable);

	List<CustomerDTO> getAllCustomersByFirstNameOrLastNameContaining(final String partialLastNameOrFirstName,
			final int page, final int limit);
}
