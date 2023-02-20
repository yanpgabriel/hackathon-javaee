package com.stefanini.resources;

import com.stefanini.dto.UserCreationDTO;
import com.stefanini.dto.UserReturnDTO;
import com.stefanini.model.User;
import com.stefanini.services.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserResouce {

    @Inject
    UserService userService;

    @GET
    @Path("/birthdays")
    public Response getBirthdaysOfMonth(@QueryParam("month") int month){
        List<UserReturnDTO> users = userService.getAllBirthdaysOfTheMonth(month).stream()
                .map(UserReturnDTO::toDTO)
                .collect(Collectors.toList());

        return Response.ok(users).build();
    }

    @GET
    @Path("/email-providers")
    public Response getAllEmailProviders(){
        return Response.ok(userService.findAllUsersEmailProviders()).build();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Integer id){
        UserReturnDTO user = UserReturnDTO.toDTO(userService.findById(id));
        return Response.ok(user).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Integer id, @Valid UserCreationDTO usuario){
        User updatedUser = usuario.toUser();
        UserReturnDTO response = UserReturnDTO.toDTO(userService.update(id, updatedUser));
        return Response.ok(response).build();
    }

    @POST
    public Response saveNewUser(@Valid UserCreationDTO usuario){
        User newUser = usuario.toUser();
        userService.save(newUser);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Integer id){
        userService.delete(id);
        return Response.ok().build();
    }
}
