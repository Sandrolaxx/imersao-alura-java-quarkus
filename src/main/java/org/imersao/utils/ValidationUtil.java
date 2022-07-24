package org.imersao.utils;

import org.imersao.dto.StickerDto;

public class ValidationUtil {

    public static void validateToken(String recivedToken, String aplicationToken) {

        if (recivedToken == null) {
            throw new StickerException("Informe um token!", 401);
        }

        if (!recivedToken.equals("Basic ".concat(aplicationToken))) {
            throw new StickerException("Token informado inválido!", 401);
        }

    }

    public static void validateData(StickerDto dto) {

        if (dto.getImagePath() == null
                || dto.getImagePath().equals("")) {
            throw new StickerException("Informe uma URL de imagem válida!", 401);
        }

    }

}
