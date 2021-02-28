package com.example.mvc.json.api.examplemvcjsonapi.controller;

import com.example.mvc.json.api.examplemvcjsonapi.payload.UserPayload;
import com.example.mvc.json.api.examplemvcjsonapi.service.UserService;
import com.mvc.json.mock.api.test.MvcJsonMockBuilder;
import com.mvc.json.mock.api.test.annotation.MvcJsonMockApi;
import com.mvc.json.mock.api.test.annotation.TestEndPoint;
import com.mvc.json.mock.api.test.core.MvcJsonMock;
import com.mvc.json.mock.api.test.exception.ApiException;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@MvcJsonMockApi(jsonPath = "unit-test/user-controller.json")
class UserControllerTest {

    private MvcJsonMock mvcJsonMock;

    private UserService userServiceMock;

    @BeforeEach
    void setUp() {
        this.userServiceMock = mock(UserService.class);

        UserController userController = new UserController(this.userServiceMock);
        this.mvcJsonMock = MvcJsonMockBuilder.standaloneSetup(userController).build();
    }

    @TestEndPoint(name = "get-user-list-empty")
    void getUserList_EmptyList_EmptyBody() throws ApiException {

        when(this.userServiceMock.getUserList()).thenReturn(Collections.emptyList());

        this.mvcJsonMock.callEndPoint();

        verify(this.userServiceMock, times(1)).getUserList();
    }

    @TestEndPoint(name = "get-user-list-with-two-users")
    void getUserList_TwoUsersFromService_TwoUsers() throws ApiException {

        UserPayload userPayload1 = UserPayload.builder().name("user1").build();
        UserPayload userPayload2 = UserPayload.builder().name("user2").build();
        List<UserPayload> userPayloadList = Stream.of(userPayload1, userPayload2).collect(Collectors.toList());

        when(this.userServiceMock.getUserList()).thenReturn(userPayloadList);

        this.mvcJsonMock.callEndPoint();

        verify(this.userServiceMock, times(1)).getUserList();
    }

    @TestEndPoint(name = "save-user-response-created")
    void saveUser_SavedCorrectly_CreatedStatus() throws ApiException {

        UserPayload userPayload = UserPayload.builder().name("user").build();

        when(this.userServiceMock.saveUser(any(UserPayload.class))).thenReturn(Optional.of(userPayload));

        this.mvcJsonMock.callEndPoint();

        verify(this.userServiceMock, times(1)).saveUser(any(UserPayload.class));
    }

    @TestEndPoint(name = "save-user-bad-request")
    void saveUser_SavedError_BadRequest() throws ApiException {

        when(this.userServiceMock.saveUser(any(UserPayload.class))).thenReturn(Optional.empty());

        this.mvcJsonMock.callEndPoint();

        verify(this.userServiceMock, times(1)).saveUser(any(UserPayload.class));
    }

    @TestEndPoint(name = "delete-user-response-ok")
    void deleteUser_DeletedCorrectly_OkStatus() throws ApiException {

        UserPayload userPayload = UserPayload.builder().name("user").build();

        when(this.userServiceMock.deleteUser(any(Long.class))).thenReturn(Optional.of(userPayload));

        this.mvcJsonMock.callEndPoint();

        verify(this.userServiceMock, times(1)).deleteUser(any(Long.class));
    }

    @TestEndPoint(name = "delete-user-bad-request")
    void deleteUser_DeletedError_BadRequest() throws ApiException {

        when(this.userServiceMock.deleteUser(any(Long.class))).thenReturn(Optional.empty());

        this.mvcJsonMock.callEndPoint();

        verify(this.userServiceMock, times(1)).deleteUser(any(Long.class));
    }

    @TestEndPoint(name = "update-user-response-ok")
    void updateUser_UpdatedCorrectly_OkStatus() throws ApiException {

        UserPayload userPayload = UserPayload.builder().name("user").build();

        when(this.userServiceMock.updateUser(any(Long.class), any(UserPayload.class))).thenReturn(Optional.of(userPayload));

        this.mvcJsonMock.callEndPoint();

        verify(this.userServiceMock, times(1)).updateUser(any(Long.class), any(UserPayload.class));
    }

    @TestEndPoint(name = "update-user-bad-request")
    void updateUser_UpdatedError_BadRequest() throws ApiException {

        when(this.userServiceMock.updateUser(any(Long.class), any(UserPayload.class))).thenReturn(Optional.empty());

        this.mvcJsonMock.callEndPoint();

        verify(this.userServiceMock, times(1)).updateUser(any(Long.class), any(UserPayload.class));
    }
}

