/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayLoadingIndicator from '@clayui/loading-indicator';
import {ClayPaginationWithBasicItems} from '@clayui/pagination';
import React, {useCallback, useContext, useEffect, useState} from 'react';

import {AppContext} from '../../AppContext.es';
import Error from '../../components/Error.es';
import QuestionRow from '../../components/QuestionRow.es';
import {getRankedThreads, getThreads} from '../../utils/client.es';
import {slugToText} from '../../utils/utils.es';
import QuestionsNavigationBar from '../QuestionsNavigationBar.es';

export default ({
	match: {
		params: {creatorId, tag},
	},
}) => {
	const [currentTag, setCurrentTag] = useState('');
	const [error, setError] = useState({});
	const [loading, setLoading] = useState(true);
	const [page, setPage] = useState(1);
	const [pageSize] = useState(20);
	const [questions, setQuestions] = useState([]);
	const [search, setSearch] = useState('');
	const [section, setSection] = useState({});

	const context = useContext(AppContext);

	const siteKey = context.siteKey;

	useEffect(() => {
		setCurrentTag(tag ? slugToText(tag) : '');
	}, [tag]);

	useEffect(() => {
		if (section.id) {
			renderQuestions(loadThreads());
		}
	}, [
		creatorId,
		page,
		pageSize,
		section,
		search,
		siteKey,
		currentTag,
		loadThreads,
	]);

	const renderQuestions = questions => {
		questions
			.then(data => setQuestions(data || []))
			.then(() => setLoading(false))
			.catch(error => {
				if (process.env.NODE_ENV === 'development') {
					console.error(error);
				}
				setLoading(false);
				setError({message: 'Loading Questions', title: 'Error'});
			});
	};

	const loadThreads = useCallback(
		sort =>
			getThreads({
				creatorId,
				keywords: currentTag,
				page,
				pageSize,
				search,
				section,
				siteKey,
				sort,
			}),
		[creatorId, currentTag, page, pageSize, search, section, siteKey]
	);

	const filterChange = type => {
		if (type === 'latest-edited') {
			renderQuestions(loadThreads('dateModified:desc'));
		}
		else if (type === 'week') {
			const date = new Date();
			date.setDate(date.getDate() - 7);

			renderQuestions(getRankedThreads(date, page, pageSize, section));
		}
		else if (type === 'month') {
			const date = new Date();
			date.setDate(date.getDate() - 31);

			renderQuestions(getRankedThreads(date, page, pageSize, section));
		}
		else {
			renderQuestions(loadThreads('dateCreated:desc'));
		}
	};

	return (
		<section className="questions-section questions-section-list">
			<div className="questions-container">
				<div className="row">
					<div className="c-mt-3 col col-xl-12">
						<QuestionsNavigationBar
							filterChange={filterChange}
							searchChange={search => setSearch(search)}
							sectionChange={section => setSection(section)}
						/>
					</div>

					<div className="c-mt-5 c-mx-auto c-px-0 col-xl-10">
						{loading ? (
							<ClayLoadingIndicator />
						) : (
							questions.items &&
							questions.items.map(question => (
								<QuestionRow
									key={question.id}
									question={question}
								/>
							))
						)}

						{!!questions.totalCount &&
							questions.totalCount > questions.pageSize && (
								<ClayPaginationWithBasicItems
									activePage={page}
									ellipsisBuffer={2}
									onPageChange={setPage}
									totalPages={Math.ceil(
										questions.totalCount /
											questions.pageSize
									)}
								/>
							)}
						<Error error={error} />
					</div>
				</div>
			</div>
		</section>
	);
};
