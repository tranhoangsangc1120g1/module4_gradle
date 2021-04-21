package com.example.demo.model;


import javax.persistence.*;

@Entity(name = "contract_details")
public class ContractDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_details_id",nullable = false)
    private int contractDetailsId;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "contract_id",nullable = false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name ="attach_service_id",referencedColumnName = "attach_service_id",nullable = false)
    private AttachService attachService;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    public int getContractDetailsId() {
        return contractDetailsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setContractDetailsId(int contractId) {
        this.contractDetailsId = contractId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
