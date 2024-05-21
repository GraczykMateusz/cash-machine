package dev.graczykmateusz.cashmachine.account.contact;

import java.util.List;

interface UserContactQueryRepository {

  List<UserContact> findByUserId(String userId);
}
