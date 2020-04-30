/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.message.body;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.liferay.portal.vulcan.internal.multipart.MultipartUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;

import java.io.InputStream;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

/**
 * @author Alejandro Hernández
 * @author Javier Gamarra
 */
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Provider
public class MultipartBodyMessageBodyReader
	implements MessageBodyReader<MultipartBody> {

	@Override
	public boolean isReadable(
		Class<?> clazz, Type genericType, Annotation[] annotations,
		MediaType mediaType) {

		return true;
	}

	@Override
	public MultipartBody readFrom(
		Class<MultipartBody> clazz, Type genericType, Annotation[] annotations,
		MediaType mediaType, MultivaluedMap<String, String> multivaluedMap,
		InputStream inputStream) {

		ContextResolver<ObjectMapper> contextResolver =
			_providers.getContextResolver(
				ObjectMapper.class, MediaType.MULTIPART_FORM_DATA_TYPE);

		try {
			Map<String, BinaryFile> binaryFiles = new HashMap<>();
			Map<String, String> values = new HashMap<>();

			Collection<Part> parts = _httpServletRequest.getParts();

			if ((parts != null) && !parts.isEmpty()) {
				for (Part part : parts) {
					String fileName = MultipartUtil.getFileName(part);

					if (fileName == null) {
						values.put(
							part.getName(),
							Streams.asString(part.getInputStream()));
					}
					else {
						binaryFiles.put(
							part.getName(),
							new BinaryFile(
								part.getContentType(), fileName,
								part.getInputStream(), part.getSize()));
					}
				}
			}

			ServletFileUpload servletFileUpload = new ServletFileUpload(
				new DiskFileItemFactory());

			List<FileItem> fileItems = servletFileUpload.parseRequest(
				_httpServletRequest);

			for (FileItem fileItem : fileItems) {
				String name = fileItem.getFieldName();

				if (fileItem.isFormField()) {
					values.put(
						name, Streams.asString(fileItem.getInputStream()));
				}
				else {
					binaryFiles.put(
						name,
						new BinaryFile(
							fileItem.getContentType(), fileItem.getName(),
							fileItem.getInputStream(), fileItem.getSize()));
				}
			}

			return MultipartBody.of(
				binaryFiles, contextResolver::getContext, values);
		}
		catch (Exception exception) {
			throw new BadRequestException(
				"Request body is not a valid multipart form", exception);
		}
	}

	@Context
	private HttpServletRequest _httpServletRequest;

	@Context
	private ObjectMapper _objectMapper;

	@Context
	private Providers _providers;

}