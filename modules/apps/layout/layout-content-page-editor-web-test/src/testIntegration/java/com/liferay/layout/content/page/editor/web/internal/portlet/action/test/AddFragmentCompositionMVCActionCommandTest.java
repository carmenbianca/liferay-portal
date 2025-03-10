/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.layout.content.page.editor.web.internal.portlet.action.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.fragment.constants.FragmentConstants;
import com.liferay.fragment.model.FragmentCollection;
import com.liferay.fragment.model.FragmentComposition;
import com.liferay.fragment.model.FragmentEntry;
import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.fragment.service.FragmentCollectionLocalService;
import com.liferay.fragment.service.FragmentCompositionLocalService;
import com.liferay.fragment.service.FragmentEntryLinkLocalService;
import com.liferay.fragment.service.FragmentEntryLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.test.util.JournalTestUtil;
import com.liferay.layout.page.template.model.LayoutPageTemplateStructure;
import com.liferay.layout.page.template.service.LayoutPageTemplateStructureLocalService;
import com.liferay.layout.util.structure.LayoutStructure;
import com.liferay.layout.util.structure.LayoutStructureItem;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.portlet.MockLiferayPortletActionRequest;
import com.liferay.portal.kernel.test.portlet.MockLiferayPortletActionResponse;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.rule.Sync;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;
import com.liferay.segments.constants.SegmentsExperienceConstants;
import com.liferay.spring.mock.web.portlet.MockActionRequest;
import com.liferay.spring.mock.web.portlet.MockActionResponse;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Pavel Savinov
 */
@RunWith(Arquillian.class)
@Sync
public class AddFragmentCompositionMVCActionCommandTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_company = _companyLocalService.getCompany(_group.getCompanyId());

		_layout = _addLayout();

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), TestPropsValues.getUserId());

		_serviceContext.setCompanyId(TestPropsValues.getCompanyId());

		ServiceContextThreadLocal.pushServiceContext(_serviceContext);
	}

	@Test
	public void testAddFragmentCompositionDefaultCollection() throws Exception {
		MockLiferayPortletActionRequest actionRequest = _getMockActionRequest();
		MockLiferayPortletActionResponse actionResponse =
			new MockLiferayPortletActionResponse();

		LayoutPageTemplateStructure layoutPageTemplateStructure =
			_layoutPageTemplateStructureLocalService.
				fetchLayoutPageTemplateStructure(
					_group.getGroupId(),
					PortalUtil.getClassNameId(Layout.class.getName()),
					_layout.getPlid(), true);

		LayoutStructure layoutStructure = LayoutStructure.of(
			layoutPageTemplateStructure.getData(
				SegmentsExperienceConstants.ID_DEFAULT));

		actionRequest.addParameter("fragmentCollectionId", String.valueOf(0));
		actionRequest.addParameter("name", RandomTestUtil.randomString());
		actionRequest.addParameter("itemId", layoutStructure.getMainItemId());

		JSONObject jsonObject = ReflectionTestUtil.invoke(
			_mvcActionCommand, "doTransactionalCommand",
			new Class<?>[] {ActionRequest.class, ActionResponse.class},
			actionRequest, actionResponse);

		Assert.assertNotNull(jsonObject);

		FragmentComposition fragmentComposition =
			_fragmentCompositionLocalService.fetchFragmentComposition(
				_group.getGroupId(), jsonObject.getString("fragmentEntryKey"));

		Assert.assertNotNull(fragmentComposition);

		FragmentCollection fragmentCollection =
			_fragmentCollectionLocalService.getFragmentCollection(
				fragmentComposition.getFragmentCollectionId());

		Assert.assertNotNull(fragmentCollection);

		Assert.assertEquals(
			"saved-fragments", fragmentCollection.getFragmentCollectionKey());
	}

	@Test
	public void testAddFragmentCompositionExistingCollection()
		throws Exception {

		MockLiferayPortletActionRequest actionRequest = _getMockActionRequest();
		MockLiferayPortletActionResponse actionResponse =
			new MockLiferayPortletActionResponse();

		LayoutPageTemplateStructure layoutPageTemplateStructure =
			_layoutPageTemplateStructureLocalService.
				fetchLayoutPageTemplateStructure(
					_group.getGroupId(),
					PortalUtil.getClassNameId(Layout.class.getName()),
					_layout.getPlid(), true);

		LayoutStructure layoutStructure = LayoutStructure.of(
			layoutPageTemplateStructure.getData(
				SegmentsExperienceConstants.ID_DEFAULT));

		FragmentCollection newFragmentCollection =
			_fragmentCollectionLocalService.addFragmentCollection(
				TestPropsValues.getUserId(), _group.getGroupId(),
				StringUtil.randomString(), StringPool.BLANK,
				ServiceContextThreadLocal.getServiceContext());

		actionRequest.addParameter(
			"fragmentCollectionId",
			String.valueOf(newFragmentCollection.getFragmentCollectionId()));

		actionRequest.addParameter("name", RandomTestUtil.randomString());
		actionRequest.addParameter("itemId", layoutStructure.getMainItemId());

		JSONObject jsonObject = ReflectionTestUtil.invoke(
			_mvcActionCommand, "doTransactionalCommand",
			new Class<?>[] {ActionRequest.class, ActionResponse.class},
			actionRequest, actionResponse);

		Assert.assertNotNull(jsonObject);

		FragmentComposition fragmentComposition =
			_fragmentCompositionLocalService.fetchFragmentComposition(
				_group.getGroupId(), jsonObject.getString("fragmentEntryKey"));

		Assert.assertNotNull(fragmentComposition);

		FragmentCollection fragmentCollection =
			_fragmentCollectionLocalService.getFragmentCollection(
				fragmentComposition.getFragmentCollectionId());

		Assert.assertNotNull(fragmentCollection);

		Assert.assertEquals(
			newFragmentCollection.getFragmentCollectionKey(),
			fragmentCollection.getFragmentCollectionKey());
	}

	@Test
	public void testAddFragmentCompositionSaveMappingConfigurationEditableLink()
		throws Exception {

		_layout = _addLayout();

		FragmentCollection fragmentCollection =
			_fragmentCollectionLocalService.addFragmentCollection(
				TestPropsValues.getUserId(), _group.getGroupId(),
				RandomTestUtil.randomString(), StringPool.BLANK,
				_serviceContext);

		String html =
			"<div><a data-lfr-editable-id=\"my-link-editable-id\" " +
				"data-lfr-editable-type=\"link\" href=\"\" id=\"my-link-id\">" +
					"Example</a></div>";

		FragmentEntry fragmentEntry =
			_fragmentEntryLocalService.addFragmentEntry(
				TestPropsValues.getUserId(), _group.getGroupId(),
				fragmentCollection.getFragmentCollectionId(),
				"example-fragment-entry-key", RandomTestUtil.randomString(),
				StringPool.BLANK, html, StringPool.BLANK, StringPool.BLANK, 0,
				FragmentConstants.TYPE_COMPONENT,
				WorkflowConstants.STATUS_APPROVED, _serviceContext);

		JournalArticle journalArticle1 = _addJournalArticle(
			RandomTestUtil.randomString());

		JournalArticle journalArticle2 = _addJournalArticle(
			RandomTestUtil.randomString());

		HashMap<String, String> valuesMap = HashMapBuilder.put(
			"FRAGMENT_COLLECTION_NAME",
			StringUtil.quote(fragmentCollection.getName(), StringPool.QUOTE)
		).put(
			"FRAGMENT_ENTRY_KEY",
			StringUtil.quote(
				fragmentEntry.getFragmentEntryKey(), StringPool.QUOTE)
		).put(
			"FRAGMENT_ENTRY_NAME",
			StringUtil.quote(fragmentEntry.getName(), StringPool.QUOTE)
		).put(
			"MAPPED_LINK_CLASS_NAME",
			StringUtil.quote(
				"com.liferay.journal.model.JournalArticle", StringPool.QUOTE)
		).put(
			"MAPPED_LINK_CLASS_NAME_ID",
			StringUtil.quote(
				String.valueOf(
					_portal.getClassNameId(
						"com.liferay.journal.model.JournalArticle")))
		).put(
			"MAPPED_LINK_CLASS_PK",
			String.valueOf(journalArticle1.getResourcePrimKey())
		).put(
			"MAPPED_LINK_DEFAULT_VALUE",
			StringUtil.quote(journalArticle1.getTitle())
		).put(
			"MAPPED_TEXT_CLASS_NAME",
			StringUtil.quote(
				"com.liferay.journal.model.JournalArticle", StringPool.QUOTE)
		).put(
			"MAPPED_TEXT_CLASS_NAME_ID",
			StringUtil.quote(
				String.valueOf(
					_portal.getClassNameId(
						"com.liferay.journal.model.JournalArticle")),
				StringPool.QUOTE)
		).put(
			"MAPPED_TEXT_CLASS_PK",
			String.valueOf(journalArticle2.getResourcePrimKey())
		).put(
			"MAPPED_TEXT_DEFAULT_VALUE",
			StringUtil.quote(journalArticle2.getTitle(), StringPool.QUOTE)
		).build();

		String editableValues = StringUtil.replace(
			_read("editable_values_with_mapping.json"), "\"${", "}\"",
			valuesMap);

		FragmentEntryLink fragmentEntryLink =
			_fragmentEntryLinkLocalService.addFragmentEntryLink(
				TestPropsValues.getUserId(), _group.getGroupId(), 0,
				fragmentEntry.getFragmentEntryId(),
				_portal.getClassNameId(Layout.class), _layout.getPlid(),
				StringPool.BLANK, html, StringPool.BLANK,
				_read("fragment_configuration.json"), editableValues,
				StringPool.BLANK, 0, null, _serviceContext);

		LayoutStructure layoutStructure = new LayoutStructure();

		LayoutStructureItem rootLayoutStructureItem =
			layoutStructure.addRootLayoutStructureItem();

		LayoutStructureItem containerLayoutStructureItem =
			layoutStructure.addContainerLayoutStructureItem(
				rootLayoutStructureItem.getItemId(), 0);

		layoutStructure.addFragmentLayoutStructureItem(
			fragmentEntryLink.getFragmentEntryLinkId(),
			containerLayoutStructureItem.getItemId(), 0);

		_layoutPageTemplateStructureLocalService.addLayoutPageTemplateStructure(
			TestPropsValues.getUserId(), _group.getGroupId(),
			_portal.getClassNameId(Layout.class.getName()), _layout.getPlid(),
			layoutStructure.toString(), _serviceContext);

		MockActionRequest mockActionRequest = _getMockActionRequest();

		mockActionRequest.addParameter(
			"description", RandomTestUtil.randomString());
		mockActionRequest.addParameter(
			"fragmentCollectionId",
			String.valueOf(fragmentCollection.getFragmentCollectionId()));
		mockActionRequest.addParameter(
			"itemId", containerLayoutStructureItem.getItemId());
		mockActionRequest.addParameter("name", RandomTestUtil.randomString());
		mockActionRequest.addParameter(
			"saveInlineContent", Boolean.TRUE.toString());
		mockActionRequest.addParameter(
			"saveMappingConfiguration", Boolean.TRUE.toString());

		JSONObject jsonObject = ReflectionTestUtil.invoke(
			_mvcActionCommand, "doTransactionalCommand",
			new Class<?>[] {ActionRequest.class, ActionResponse.class},
			mockActionRequest, new MockActionResponse());

		Assert.assertEquals(
			String.valueOf(fragmentCollection.getFragmentCollectionId()),
			jsonObject.getString("fragmentCollectionId"));
		Assert.assertEquals(
			fragmentCollection.getName(),
			jsonObject.getString("fragmentCollectionName"));

		Assert.assertTrue(
			Validator.isNotNull(jsonObject.getString("fragmentEntryKey")));
		Assert.assertEquals(
			String.valueOf(_group.getGroupId()),
			jsonObject.getString("groupId"));
		Assert.assertEquals(
			mockActionRequest.getParameter("name"),
			jsonObject.getString("name"));
		Assert.assertEquals("composition", jsonObject.getString("type"));

		FragmentComposition fragmentComposition =
			_fragmentCompositionLocalService.fetchFragmentComposition(
				_group.getGroupId(), jsonObject.getString("fragmentEntryKey"));

		Assert.assertNotNull(fragmentComposition);
		Assert.assertEquals(
			mockActionRequest.getParameter("description"),
			fragmentComposition.getDescription());
		Assert.assertEquals(
			mockActionRequest.getParameter("name"),
			fragmentComposition.getName());

		String expectedFragmentCompositionData = StringUtil.replace(
			_read("expected_fragment_composition_data.json"), "\"${", "}\"",
			valuesMap);

		JSONObject expectedFragmentCompositionDataJSONObject =
			JSONFactoryUtil.createJSONObject(expectedFragmentCompositionData);

		JSONObject fragmentCompositionDataJSONObject =
			fragmentComposition.getDataJSONObject();

		Assert.assertEquals(
			expectedFragmentCompositionDataJSONObject.toJSONString(),
			fragmentCompositionDataJSONObject.toJSONString());
	}

	@Test
	public void testAddFragmentCompositionWithThumbnail() throws Exception {
		MockLiferayPortletActionRequest actionRequest = _getMockActionRequest();
		MockLiferayPortletActionResponse actionResponse =
			new MockLiferayPortletActionResponse();

		LayoutPageTemplateStructure layoutPageTemplateStructure =
			_layoutPageTemplateStructureLocalService.
				fetchLayoutPageTemplateStructure(
					_group.getGroupId(),
					PortalUtil.getClassNameId(Layout.class.getName()),
					_layout.getPlid(), true);

		LayoutStructure layoutStructure = LayoutStructure.of(
			layoutPageTemplateStructure.getData(
				SegmentsExperienceConstants.ID_DEFAULT));

		FragmentCollection newFragmentCollection =
			_fragmentCollectionLocalService.addFragmentCollection(
				TestPropsValues.getUserId(), _group.getGroupId(),
				StringUtil.randomString(), StringPool.BLANK,
				ServiceContextThreadLocal.getServiceContext());

		actionRequest.addParameter(
			"fragmentCollectionId",
			String.valueOf(newFragmentCollection.getFragmentCollectionId()));

		actionRequest.addParameter("name", RandomTestUtil.randomString());
		actionRequest.addParameter("itemId", layoutStructure.getMainItemId());
		actionRequest.addParameter("previewImageURL", _THUMBNAIL_DATA);

		JSONObject jsonObject = ReflectionTestUtil.invoke(
			_mvcActionCommand, "doTransactionalCommand",
			new Class<?>[] {ActionRequest.class, ActionResponse.class},
			actionRequest, actionResponse);

		Assert.assertNotNull(jsonObject);

		FragmentComposition fragmentComposition =
			_fragmentCompositionLocalService.fetchFragmentComposition(
				_group.getGroupId(), jsonObject.getString("fragmentEntryKey"));

		Assert.assertNotNull(fragmentComposition);
		Assert.assertTrue(fragmentComposition.getPreviewFileEntryId() > 0);
	}

	private JournalArticle _addJournalArticle(String title) throws Exception {
		Map<Locale, String> titleMap = HashMapBuilder.put(
			LocaleUtil.US, title
		).build();

		Map<Locale, String> contentMap = HashMapBuilder.put(
			LocaleUtil.US, RandomTestUtil.randomString()
		).build();

		return JournalTestUtil.addArticle(
			_group.getGroupId(), 0,
			PortalUtil.getClassNameId(JournalArticle.class), titleMap, null,
			contentMap, LocaleUtil.getSiteDefault(), false, true,
			_serviceContext);
	}

	private Layout _addLayout() throws PortalException {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getGroupId(), TestPropsValues.getUserId());

		String randomString = FriendlyURLNormalizerUtil.normalize(
			RandomTestUtil.randomString());

		String friendlyURL = StringPool.SLASH + randomString;

		return LayoutLocalServiceUtil.addLayout(
			TestPropsValues.getUserId(), _group.getGroupId(), false,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
			RandomTestUtil.randomString(), null, RandomTestUtil.randomString(),
			LayoutConstants.TYPE_CONTENT, false, friendlyURL, serviceContext);
	}

	private MockActionRequest _getMockActionRequest() throws PortalException {
		MockActionRequest mockActionRequest = new MockActionRequest();

		mockActionRequest.setAttribute(
			WebKeys.THEME_DISPLAY, _getThemeDisplay());

		mockActionRequest.addParameter(
			"groupId", String.valueOf(_group.getGroupId()));

		return mockActionRequest;
	}

	private ThemeDisplay _getThemeDisplay() throws PortalException {
		ThemeDisplay themeDisplay = new ThemeDisplay();

		themeDisplay.setCompany(_company);
		themeDisplay.setLayout(_layout);
		themeDisplay.setLayoutSet(_layout.getLayoutSet());
		themeDisplay.setPermissionChecker(
			PermissionThreadLocal.getPermissionChecker());
		themeDisplay.setPlid(_layout.getPlid());
		themeDisplay.setScopeGroupId(_group.getGroupId());
		themeDisplay.setSiteGroupId(_group.getGroupId());
		themeDisplay.setUser(TestPropsValues.getUser());

		return themeDisplay;
	}

	private String _read(String fileName) throws Exception {
		return new String(
			FileUtil.getBytes(getClass(), "dependencies/" + fileName));
	}

	private static final String _THUMBNAIL_DATA =
		"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAA" +
			"AADUlEQVQYV2M4c+bMfwAIMANkq3cY2wAAAABJRU5ErkJggg==";

	private Company _company;

	@Inject
	private CompanyLocalService _companyLocalService;

	@Inject
	private FragmentCollectionLocalService _fragmentCollectionLocalService;

	@Inject
	private FragmentCompositionLocalService _fragmentCompositionLocalService;

	@Inject
	private FragmentEntryLinkLocalService _fragmentEntryLinkLocalService;

	@Inject
	private FragmentEntryLocalService _fragmentEntryLocalService;

	@DeleteAfterTestRun
	private Group _group;

	private Layout _layout;

	@Inject
	private LayoutPageTemplateStructureLocalService
		_layoutPageTemplateStructureLocalService;

	@Inject(
		filter = "mvc.command.name=/content_layout/add_fragment_composition"
	)
	private MVCActionCommand _mvcActionCommand;

	@Inject
	private Portal _portal;

	private ServiceContext _serviceContext;

	private static class MockActionRequest
		extends MockLiferayPortletActionRequest {

		@Override
		public HttpServletRequest getHttpServletRequest() {
			return new MockHttpServletRequest();
		}

	}

}