package com.nttdata.hibernate_t1;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.hibernate_t1.services.ClientManagementServiceI;
import com.nttdata.hibernate_t1.services.ClientManagementServiceImpl;
import com.nttdata.hibernate_t1.services.ContractManagementServiceI;
import com.nttdata.hibernate_t1.services.ContractManagementServiceImpl;
import com.nttdata.hibernate_t1.services.SellerManagementServiceI;
import com.nttdata.hibernate_t1.services.SellerManagementServiceImpl;
import com.nttdata.hibernate_t1.utilities.InterfaceUtils;
import com.nttdata.hibernate_t1.persistence.Contract;
import com.nttdata.hibernate_t1.persistence.Seller;
import com.nttdata.hibernate_t1.App;
import com.nttdata.hibernate_t1.persistence.Client;


/**
 * NTTData Taller Hibernate T1
 * 
 * @author Fernando Pérez Nieto
 *
 */
public class App 
{
	
	/** Logger */
	private static Logger log = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	log.debug(InterfaceUtils.INIT);
    	
    	//Open session
    	final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();
    			
    	// Service Initialize
    	final ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);
    	final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);
    	final SellerManagementServiceI sellerService = new SellerManagementServiceImpl(session);
    	
		// Auditory
		final String updatedUser = "FernandoPerezNieto";
		final Date updatedDate = new Date();
		
		//Seller generation
		final Seller sellerA = new Seller();
		sellerA.setName("Federico");
		sellerA.setFirstSurname("Agapito");
		sellerA.setSecondSurname("DiSousa");
		sellerA.setPhone("+34 643 43 43");
		sellerA.setUpdatedDate(updatedDate);
		sellerA.setUpdatedUser(updatedUser);
		
		final Seller sellerB = new Seller();
		sellerB.setName("Antonio");
		sellerB.setFirstSurname("Rockefeller");
		sellerB.setSecondSurname("Rockefeller");
		sellerB.setPhone("+34 655 22 32");
		sellerB.setUpdatedDate(updatedDate);
		sellerB.setUpdatedUser(updatedUser);
		
		// Client generation
		final Client clientA = new Client();
		clientA.setName("Jonatan");
		clientA.setDni("28929933G");
		clientA.setFirstSurname("Carrera");
		clientA.setSecondSurname("Viera");
		clientA.setSeller(sellerA);
		clientA.setUpdatedDate(updatedDate);
		clientA.setUpdatedUser(updatedUser);

		final Client clientB = new Client();
		clientB.setName("Pablito");
		clientB.setDni("28841542W");
		clientB.setFirstSurname("Dominguez");
		clientB.setSecondSurname("Romero");
		clientB.setSeller(sellerB);
		clientB.setUpdatedDate(updatedDate);
		clientB.setUpdatedUser(updatedUser);
		
		final Client clientC = new Client();
		clientC.setName("Rafinha Felipez");
		clientC.setDni("49528013C");
		clientC.setFirstSurname("Herrera");
		clientC.setSecondSurname("Chavez");
		clientC.setSeller(sellerB);
		clientC.setUpdatedDate(updatedDate);
		clientC.setUpdatedUser(updatedUser);
		
		final Client clientD = new Client();
		clientD.setName("Eva");
		clientD.setDni("29628444M");
		clientD.setFirstSurname("Cardenas");
		clientD.setSecondSurname("Bermudez");
		clientD.setSeller(sellerA);
		clientD.setUpdatedDate(updatedDate);
		clientD.setUpdatedUser(updatedUser);
    	
		//Contract generation
		Date effectiveDate;
		Date expiryDate;
		
		//Contract1
		final Contract contract1 = new Contract();
		contract1.setClient(clientA);
		effectiveDate = Date.from(Instant.parse("2021-03-08T00:00:00.000Z"));
		contract1.setEffectiveDate(effectiveDate);
		expiryDate = Date.from(Instant.parse("2023-03-08T00:00:00.000Z"));
		contract1.setExpiryDate(expiryDate);
		contract1.setSalary(1200.36);
		contract1.setUpdatedDate(updatedDate);
		contract1.setUpdatedUser(updatedUser);
		
		//Contract2
		final Contract contract2 = new Contract();
		contract2.setClient(clientB);
		effectiveDate = Date.from(Instant.parse("2019-02-12T00:00:00.000Z"));
		contract2.setEffectiveDate(effectiveDate);
		expiryDate = Date.from(Instant.parse("2021-02-12T00:00:00.000Z"));
		contract2.setExpiryDate(expiryDate);
		contract2.setSalary(978.01);
		contract2.setUpdatedDate(updatedDate);
		contract2.setUpdatedUser(updatedUser);
		
		//Contract3
		final Contract contract3 = new Contract();
		contract3.setClient(clientB);
		effectiveDate = Date.from(Instant.parse("2015-01-02T00:00:00.000Z"));
		contract3.setEffectiveDate(effectiveDate);
		expiryDate = Date.from(Instant.parse("2025-01-02T00:00:00.000Z"));
		contract3.setExpiryDate(expiryDate);
		contract3.setSalary(3180.90);
		contract3.setUpdatedDate(updatedDate);
		contract3.setUpdatedUser(updatedUser);
		
		//Contract4
		final Contract contract4 = new Contract();
		effectiveDate = Date.from(Instant.parse("1993-12-12T00:00:00.000Z"));
		contract4.setEffectiveDate(effectiveDate);
		expiryDate = Date.from(Instant.parse("1997-12-12T00:00:00.000Z"));
		contract4.setExpiryDate(expiryDate);
		contract4.setSalary(1812.87);
		contract4.setUpdatedDate(updatedDate);
		contract4.setUpdatedUser(updatedUser);
		
		//Contract5
		final Contract contract5 = new Contract();
		contract5.setClient(clientC);
		effectiveDate = Date.from(Instant.parse("1994-12-12T00:00:00.000Z"));
		contract5.setEffectiveDate(effectiveDate);
		expiryDate = Date.from(Instant.parse("1999-12-12T00:00:00.000Z"));
		contract5.setExpiryDate(expiryDate);
		contract5.setSalary(1450.87);
		contract5.setUpdatedDate(updatedDate);
		contract5.setUpdatedUser(updatedUser);
		
		//Contract6
		final Contract contract6 = new Contract();
		contract6.setClient(clientC);
		effectiveDate = Date.from(Instant.parse("1991-12-12T00:00:00.000Z"));
		contract6.setEffectiveDate(effectiveDate);
		expiryDate = Date.from(Instant.parse("1996-12-12T00:00:00.000Z"));
		contract6.setExpiryDate(expiryDate);
		contract6.setSalary(1612.47);
		contract6.setUpdatedDate(updatedDate);
		contract6.setUpdatedUser(updatedUser);
		
		//Asignacion de contractos
		List<Contract> lista = new ArrayList<>();
		lista.add(contract1);
		lista.add(contract4);
		clientA.setContractsList(lista);
		
		lista = new ArrayList<>();
		lista.add(contract2);
		lista.add(contract3);
		clientB.setContractsList(lista);
		
		lista = new ArrayList<>();
		lista.add(contract5);
		lista.add(contract6);
		clientC.setContractsList(lista);
		
		lista = new ArrayList<>();
		clientD.setContractsList(lista);

		
		//Insert contracts
		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);
		contractService.insertNewContract(contract3);
		contractService.insertNewContract(contract4);
		contractService.insertNewContract(contract5);
		contractService.insertNewContract(contract6);
		
		//Insert clients
		clientService.insertNewClient(clientA);
		clientService.insertNewClient(clientB);
		clientService.insertNewClient(clientC);
		clientService.insertNewClient(clientD);
		
		//Asignacion de clientes
		List<Client> lista1 = new ArrayList<>();
		lista1.add(clientA);
		lista1.add(clientD);
		sellerA.setClientsList(lista1);
		
		lista1 = new ArrayList<>();
		lista1.add(clientB);
		lista1.add(clientC);
		sellerB.setClientsList(lista1);
		
		//Insert sellers
		sellerService.insertNewSeller(sellerA);
		sellerService.insertNewSeller(sellerB);
		

		// Query
		System.out.println("\nCientes llamados 'Jonatan' con más de 1200 de salario en algun contrato:\n");
		List<Client> clients = clientService.searchByNameAndSalary("Jonatan", 1200.00);
		for (final Client client : clients) {
			for(final Contract contract : client.getContractsList()) {
				System.out.println(InterfaceUtils.toStrBuilder(String.valueOf(client.getId()), " | ", client.getName(), " | ",
						client.getFirstSurname(), " | ", client.getSecondSurname(), " | ", String.valueOf(contract.getSalary())));
			}
		}
		
		// Query
		System.out.println("\nTodos los clientes:\n");
		clients = clientService.searchAll();
		for (final Client client : clients) {
			System.out.println(InterfaceUtils.toStrBuilder(String.valueOf(client.getId()), " | ", client.getName(), " | ",
				client.getFirstSurname(), " | ", client.getSecondSurname()));
		}
		
		// Query
		System.out.println("\nClientes asignados al vendedor con id 1 (Federico Agapito DiSousa):\n");
		clients = clientService.searchBySeller(1);
		for (final Client client : clients) {
			System.out.println(InterfaceUtils.toStrBuilder(String.valueOf(client.getId()), " | ", client.getName(), " | ",
					client.getFirstSurname(), " | ", client.getSecondSurname()));
		}
		
		// Close session
		session.close();
		
    	log.debug(InterfaceUtils.END);
    }
}
