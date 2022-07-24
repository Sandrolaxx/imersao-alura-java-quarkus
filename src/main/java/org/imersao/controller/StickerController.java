package org.imersao.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.imersao.dto.StickerDto;
import org.imersao.service.StickerService;
import org.imersao.utils.ValidationUtil;

/**
 *
 * @author SRamos
 */
@Path("")
public class StickerController {

    @Inject
    StickerService stickerService;

    @ConfigProperty(name = "token")
    String API_TOKEN;

    @POST
    @Path("/image")
    @Consumes("application/json")
    public byte[] generate(StickerDto stickerDto, @HeaderParam("Authorization") String token) throws Exception {

        ValidationUtil.validateData(stickerDto);
        ValidationUtil.validateToken(token, API_TOKEN);

        return stickerService.handleCreate(stickerDto);
    }

}
