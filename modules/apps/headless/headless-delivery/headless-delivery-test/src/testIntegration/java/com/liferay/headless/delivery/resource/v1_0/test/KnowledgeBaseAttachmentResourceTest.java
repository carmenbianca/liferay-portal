/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.headless.delivery.client.dto.v1_0.KnowledgeBaseAttachment;
import com.liferay.headless.delivery.client.http.HttpInvoker;
import com.liferay.knowledge.base.model.KBArticle;
import com.liferay.knowledge.base.model.KBFolder;
import com.liferay.knowledge.base.service.KBArticleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class KnowledgeBaseAttachmentResourceTest
	extends BaseKnowledgeBaseAttachmentResourceTestCase {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGuestPermissions(true);
		serviceContext.setScopeGroupId(testGroup.getGroupId());

		_kbArticle = KBArticleLocalServiceUtil.addKBArticle(
			UserLocalServiceUtil.getDefaultUserId(testGroup.getCompanyId()),
			PortalUtil.getClassNameId(KBFolder.class.getName()), 0,
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(), null,
			null, null, serviceContext);
	}

	@Override
	protected void assertValid(
			KnowledgeBaseAttachment knowledgeBaseAttachment,
			Map<String, File> multipartFiles)
		throws Exception {

		Assert.assertEquals(
			new String(FileUtil.getBytes(multipartFiles.get("file"))),
			_read(
				"http://localhost:8080" +
					knowledgeBaseAttachment.getContentUrl()));
	}

	@Override
	protected String[] getAdditionalAssertFieldNames() {
		return new String[] {"title"};
	}

	@Override
	protected Map<String, File> getMultipartFiles() {
		return HashMapBuilder.<String, File>put(
			"file",
			() -> {
				File file = new File(_tempFileName);

				String randomString = RandomTestUtil.randomString();

				FileUtil.write(file, randomString.getBytes());

				return file;
			}
		).build();
	}

	@Override
	protected KnowledgeBaseAttachment randomKnowledgeBaseAttachment()
		throws Exception {

		KnowledgeBaseAttachment knowledgeBaseAttachment =
			super.randomKnowledgeBaseAttachment();

		_tempFileName = FileUtil.createTempFileName();

		File file = new File(_tempFileName);

		knowledgeBaseAttachment.setTitle(file.getName());

		return knowledgeBaseAttachment;
	}

	@Override
	protected KnowledgeBaseAttachment
			testDeleteKnowledgeBaseAttachment_addKnowledgeBaseAttachment()
		throws Exception {

		return knowledgeBaseAttachmentResource.
			postKnowledgeBaseArticleKnowledgeBaseAttachment(
				_kbArticle.getResourcePrimKey(),
				randomKnowledgeBaseAttachment(), getMultipartFiles());
	}

	@Override
	protected Long
		testGetKnowledgeBaseArticleKnowledgeBaseAttachmentsPage_getKnowledgeBaseArticleId() {

		return _kbArticle.getResourcePrimKey();
	}

	@Override
	protected KnowledgeBaseAttachment
			testGetKnowledgeBaseAttachment_addKnowledgeBaseAttachment()
		throws Exception {

		return knowledgeBaseAttachmentResource.
			postKnowledgeBaseArticleKnowledgeBaseAttachment(
				_kbArticle.getResourcePrimKey(),
				randomKnowledgeBaseAttachment(), getMultipartFiles());
	}

	@Override
	protected KnowledgeBaseAttachment
			testGraphQLKnowledgeBaseAttachment_addKnowledgeBaseAttachment()
		throws Exception {

		return testDeleteKnowledgeBaseAttachment_addKnowledgeBaseAttachment();
	}

	private String _read(String url) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);
		httpInvoker.path(url);
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	private KBArticle _kbArticle;
	private String _tempFileName;

}