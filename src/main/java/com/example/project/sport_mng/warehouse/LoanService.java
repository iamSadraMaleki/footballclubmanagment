package com.example.project.sport_mng.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan createLoan(Loan loan) {
        Item item = itemRepository.findById(loan.getItem().getId())
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        if (item.getQuantity() < loan.getQuantityLoaned()) {
            throw new IllegalArgumentException("Insufficient quantity in inventory");
        }

        item.setQuantity(item.getQuantity() - loan.getQuantityLoaned());
        itemRepository.save(item);

        return loanRepository.save(loan);
    }

    public Loan updateLoan(Long id, Loan updatedLoan) {
        return loanRepository.findById(id)
                .map(loan -> {
                    Item item = loan.getItem();

                    if (item.getQuantity() + loan.getQuantityLoaned() < updatedLoan.getQuantityLoaned()) {
                        throw new IllegalArgumentException("Insufficient quantity in inventory");
                    }

                    item.setQuantity(item.getQuantity() + loan.getQuantityLoaned() - updatedLoan.getQuantityLoaned());
                    itemRepository.save(item);

                    loan.setBorrowerName(updatedLoan.getBorrowerName());
                    loan.setLoanDate(updatedLoan.getLoanDate());
                    loan.setQuantityLoaned(updatedLoan.getQuantityLoaned());
                    return loanRepository.save(loan);
                }).orElseThrow(() -> new IllegalArgumentException("Loan not found"));
    }

    public void deleteLoan(Long id) {
        loanRepository.findById(id).ifPresent(loan -> {
            Item item = loan.getItem();
            item.setQuantity(item.getQuantity() + loan.getQuantityLoaned());
            itemRepository.save(item);
            loanRepository.deleteById(id);
        });
    }
}
