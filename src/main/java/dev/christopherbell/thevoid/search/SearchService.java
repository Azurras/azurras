package dev.christopherbell.thevoid.search;

import dev.christopherbell.libs.common.api.exceptions.InvalidRequestException;
import dev.christopherbell.libs.common.api.utils.APIValidationUtils;
import dev.christopherbell.thevoid.common.VoidResponse;
import dev.christopherbell.thevoid.account.model.dto.Account;
import dev.christopherbell.thevoid.account.AccountMessenger;
import dev.christopherbell.thevoid.utils.ValidateUtil;
import dev.christopherbell.thevoid.utils.mappers.MapStructMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
@Slf4j
public class SearchService {

  private final AccountMessenger accountMessenger;
  private final MapStructMapper mapStructMapper;

  public VoidResponse search(String clientId, String searchTerm) throws InvalidRequestException {
    APIValidationUtils.isValidClientId(ValidateUtil.ACCEPTED_CLIENT_IDs, clientId);
    //TODO: Make sure search term isn't malicious

    var accountEntityResults = this.accountMessenger.searchAccounts(searchTerm);
    var accountResults = new ArrayList<Account>();
    for (var accountEntity : accountEntityResults) {
      var account = this.mapStructMapper.mapToAccount(accountEntity);
      accountResults.add(account);
    }

    return VoidResponse.builder()
        .accounts(accountResults)
        .build();
  }
}
