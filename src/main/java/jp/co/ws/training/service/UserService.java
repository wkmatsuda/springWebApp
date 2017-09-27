package jp.co.ws.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ws.training.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

}
