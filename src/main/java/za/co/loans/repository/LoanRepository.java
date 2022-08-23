package za.co.loans.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import za.co.loans.domain.LoanApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class LoanRepository {

    private Map<String, LoanApplication> applications = new HashMap<>();

    public void add(LoanApplication application) {
        if (Objects.isNull(applications))
            applications = new HashMap<>();

        if (!applications.containsKey(application.getIdNumber())) {
            applications.put(application.getIdNumber(), application);
        }
    }

    public void deleteAll() {
        if (!CollectionUtils.isEmpty(applications))
            applications.clear();
    }
}
