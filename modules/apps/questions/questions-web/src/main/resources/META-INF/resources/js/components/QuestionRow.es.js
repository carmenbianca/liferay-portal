/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {dateToInternationalHuman, normalizeRating} from '../utils/utils.es';
import ArticleBodyRenderer from './ArticleBodyRenderer.es';
import Link from './Link.es';
import QuestionBadge from './QuestionsBadge.es';
import SectionLabel from './SectionLabel.es';
import TagList from './TagList.es';
import UserIcon from './UserIcon.es';

export default ({question}) => {
	const hasValidAnswer = question =>
		question.messageBoardMessages.items.filter(
			message => message.showAsAnswer
		).length > 0;

	const sectionTitle = question.messageBoardSection.title;

	return (
		<div className="c-mt-4 c-p-3 position-relative question-row text-secondary">
			<div className="align-items-center d-flex flex-wrap justify-content-between">
				<SectionLabel section={question.messageBoardSection} />

				<ul className="c-mb-0 d-flex flex-wrap list-unstyled stretched-link-layer">
					<li>
						<QuestionBadge
							symbol={
								normalizeRating(question.aggregateRating) < 0
									? 'caret-bottom'
									: 'caret-top'
							}
							value={normalizeRating(question.aggregateRating)}
						/>
					</li>

					<li>
						<QuestionBadge
							symbol="view"
							value={question.viewCount}
						/>
					</li>

					<li>
						<QuestionBadge
							className={
								hasValidAnswer(question)
									? 'alert-success border-0'
									: ''
							}
							symbol={
								hasValidAnswer(question)
									? 'check-circle-full'
									: 'message'
							}
							value={question.messageBoardMessages.items.length}
						/>
					</li>
				</ul>
			</div>

			<Link
				className="questions-title stretched-link"
				to={`/questions/${sectionTitle}/${question.friendlyUrlPath}`}
			>
				<h2 className="c-mb-0 stretched-link-layer text-dark">
					{question.headline}
				</h2>
			</Link>

			<div className="c-mb-0 c-mt-3 question-row-article-body stretched-link-layer text-truncate">
				<ArticleBodyRenderer {...question} />
			</div>

			<div className="align-items-sm-center align-items-start d-flex flex-column-reverse flex-sm-row justify-content-between">
				<div className="c-mt-3 c-mt-sm-0 stretched-link-layer">
					<Link
						to={`/questions/${sectionTitle}/creator/${question.creator.id}`}
					>
						<UserIcon
							fullName={question.creator.name}
							portraitURL={question.creator.image}
							size="sm"
							userId={String(question.creator.id)}
						/>

						<strong className="c-ml-2 text-dark">
							{question.creator.name}
						</strong>
					</Link>

					<span className="c-ml-2 small">
						{'- ' + dateToInternationalHuman(question.dateModified)}
					</span>
				</div>

				<TagList tags={question.keywords} />
			</div>
		</div>
	);
};
