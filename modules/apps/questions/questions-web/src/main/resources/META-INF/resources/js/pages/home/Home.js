/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayCard from '@clayui/card';
import React, {useContext, useEffect, useState} from 'react';

import {AppContext} from '../../AppContext.es';
import Link from '../../components/Link.es';
import {getSections} from '../../utils/client.es';
import lang from '../../utils/lang.es';

export default () => {
	const context = useContext(AppContext);

	const [sections, setSections] = useState([]);

	useEffect(() => {
		getSections(context.siteKey).then(sections =>
			setSections(sections.items || [])
		);
	}, [context.siteKey]);

	function descriptionTruncate(description) {
		return description.length > 150
			? description.substring(0, 150) + '...'
			: description;
	}

	return (
		<section className="questions-section questions-section-cards">
			<div className="questions-container">
				<div className="row">
					{sections.map(section => (
						<div
							className="c-mb-4 col-lg-4 col-md-6 col-xl-3"
							key={section.id}
						>
							<Link
								className="questions-card text-decoration-none text-secondary"
								to={`/questions/${section.title}`}
							>
								<ClayCard>
									<ClayCard.Body>
										<ClayCard.Description
											className="text-dark"
											displayType="title"
										>
											{section.title}
										</ClayCard.Description>

										<ClayCard.Description
											className="c-mt-3"
											displayType="text"
											truncate={false}
										>
											{descriptionTruncate(
												section.description
											)}
										</ClayCard.Description>

										<ClayCard.Description
											className="c-mt-4 small"
											displayType="text"
											truncate={false}
										>
											<span>
												{lang.sub(
													Liferay.Language.get(
														'x-questions'
													),
													[
														section.numberOfMessageBoardThreads,
													]
												)}
											</span>

											<button className="btn btn-link btn-sm d-xl-none float-right font-weight-bold p-0">
												View Topic
											</button>
										</ClayCard.Description>
									</ClayCard.Body>
								</ClayCard>
							</Link>
						</div>
					))}
				</div>
			</div>
		</section>
	);
};
