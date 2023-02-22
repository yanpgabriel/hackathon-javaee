package com.stefanini.resources;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.stefanini.dto.UsuarioCompletoDto;
import com.stefanini.exception.MesNaoExisteException;
import com.stefanini.exception.UsuarioIdNaoExisteException;
import com.stefanini.exception.UsuarioLoginJaExisteException;
import com.stefanini.service.UsuarioService;
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("usuario")
public class UsuarioResource {

    @Inject
    private UsuarioService usuarioService;

    @POST
    public Response save(@Valid UsuarioCompletoDto usuario) throws UsuarioLoginJaExisteException{
        return Response.status(Status.CREATED).entity(usuarioService.save(usuario)).build();
    }

    @PUT
    public Response update(@Valid UsuarioCompletoDto usuario) throws UsuarioLoginJaExisteException,UsuarioIdNaoExisteException{
        return Response.status(Status.CREATED).entity(usuarioService.update(usuario)).build();
    }

    @GET
    public Response listAll(){
        return Response.status(Status.OK).entity(usuarioService.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam(value = "id") Long id) throws UsuarioIdNaoExisteException{
        return Response.status(Status.OK).entity(usuarioService.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam(value = "id") Long id) throws UsuarioIdNaoExisteException{
        usuarioService.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/aniversariantes/{mes}")
    public Response listAllBirthdaysUsersFromMonth(@PathParam(value = "mes") int mes) throws MesNaoExisteException{
        return Response.status(Status.OK).entity(usuarioService.listAllBirthdaysUsersFromMonth(mes)).build();
    }

    @GET
    @Path("/provedores-emails")
    public Response listAllUsersEmailProviders() {
        return Response.status(Status.OK).entity(usuarioService.listAllUsersEmailProviders()).build();
    }
}
