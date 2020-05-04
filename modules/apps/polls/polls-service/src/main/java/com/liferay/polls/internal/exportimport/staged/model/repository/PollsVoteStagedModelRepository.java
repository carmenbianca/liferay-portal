/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.internal.exportimport.staged.model.repository;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.staged.model.repository.StagedModelRepository;
import com.liferay.polls.model.PollsVote;
import com.liferay.polls.service.PollsVoteLocalService;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.polls.model.PollsVote",
	service = StagedModelRepository.class
)
public class PollsVoteStagedModelRepository
	implements StagedModelRepository<PollsVote> {

	@Override
	public PollsVote addStagedModel(
			PortletDataContext portletDataContext, PollsVote pollsVote)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteStagedModel(PollsVote pollsVote) throws PortalException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteStagedModels(PortletDataContext portletDataContext)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Override
	public PollsVote fetchMissingReference(String uuid, long groupId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PollsVote fetchStagedModelByUuidAndGroupId(
		String uuid, long groupId) {

		throw new UnsupportedOperationException();
	}

	@Override
	public List<PollsVote> fetchStagedModelsByUuidAndCompanyId(
		String uuid, long companyId) {

		throw new UnsupportedOperationException();
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext) {

		throw new UnsupportedOperationException();
	}

	@Override
	public PollsVote getStagedModel(long voteId) throws PortalException {
		return _pollsVoteLocalService.getPollsVote(voteId);
	}

	@Override
	public void restoreStagedModel(
			PortletDataContext portletDataContext, PollsVote pollsVote)
		throws PortletDataException {

		throw new UnsupportedOperationException();
	}

	@Override
	public PollsVote saveStagedModel(PollsVote pollsVote)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Override
	public PollsVote updateStagedModel(
			PortletDataContext portletDataContext, PollsVote pollsVote)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Reference
	private PollsVoteLocalService _pollsVoteLocalService;

}