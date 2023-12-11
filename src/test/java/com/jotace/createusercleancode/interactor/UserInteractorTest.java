package com.jotace.createusercleancode.interactor;

import com.jotace.createusercleancode.application.gateway.UserGateway;
import com.jotace.createusercleancode.application.model.UserRequestModel;
import com.jotace.createusercleancode.application.model.UserResponseModel;
import com.jotace.createusercleancode.application.presenter.CreateUserPresenter;
import com.jotace.createusercleancode.application.presenter.UpdateUserPresenter;
import com.jotace.createusercleancode.application.usecases.UserInteractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

public class UserInteractorTest {

    private UserInteractor userInteractor;
    private UserGateway userGateway;
    private CreateUserPresenter createUserPresenter;
    private UpdateUserPresenter updateUserPresenter;

    @BeforeEach
    void setUp() {
        // Configuração dos mocks ou instâncias reais (se aplicável)
        userGateway = mock(UserGateway.class);
        createUserPresenter = mock(CreateUserPresenter.class);
        updateUserPresenter = mock(UpdateUserPresenter.class);

        userInteractor = new UserInteractor(userGateway, createUserPresenter, updateUserPresenter);
    }

    @Test
    void testCreateUser_WithInvalidPassword_ShouldReturnFailView() {
        UserRequestModel requestModel = new UserRequestModel("username", "pass",
                "email@example.com", LocalDateTime.now());

        UserResponseModel response = userInteractor.create(requestModel);

        verify(createUserPresenter).prepareFailView("User password must have more than 5 characters.");
    }
}
