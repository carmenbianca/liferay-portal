/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.resource.v1_0;

import com.liferay.headless.delivery.dto.v1_0.Comment;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Locale;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-delivery/v1.0
 *
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
@ProviderType
public interface CommentResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<Comment> getBlogPostingCommentsPage(
			Long blogPostingId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public Comment postBlogPostingComment(Long blogPostingId, Comment comment)
		throws Exception;

	public Response postBlogPostingCommentBatch(
			Long blogPostingId, String callbackURL, Object object)
		throws Exception;

	public void deleteComment(Long commentId) throws Exception;

	public Response deleteCommentBatch(String callbackURL, Object object)
		throws Exception;

	public Comment getComment(Long commentId) throws Exception;

	public Comment putComment(Long commentId, Comment comment) throws Exception;

	public Response putCommentBatch(String callbackURL, Object object)
		throws Exception;

	public Page<Comment> getCommentCommentsPage(
			Long parentCommentId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public Comment postCommentComment(Long parentCommentId, Comment comment)
		throws Exception;

	public Page<Comment> getDocumentCommentsPage(
			Long documentId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public Comment postDocumentComment(Long documentId, Comment comment)
		throws Exception;

	public Response postDocumentCommentBatch(
			Long documentId, String callbackURL, Object object)
		throws Exception;

	public Page<Comment> getStructuredContentCommentsPage(
			Long structuredContentId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public Comment postStructuredContentComment(
			Long structuredContentId, Comment comment)
		throws Exception;

	public Response postStructuredContentCommentBatch(
			Long structuredContentId, String callbackURL, Object object)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public CommentResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}