/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayCard, {ClayCardWithNavigation} from '@clayui/card';
import {ClayPaginationWithBasicItems} from '@clayui/pagination';
import React, {useContext, useEffect, useState} from 'react';
import {withRouter} from 'react-router-dom';

import {AppContext} from '../../AppContext.es';
import Link from '../../components/Link.es';
import {getTags} from '../../utils/client.es';
import lang from '../../utils/lang.es';
import {dateToInternationalHuman} from '../../utils/utils.es';

export default withRouter(
	({
		match: {
			params: {sectionTitle},
		},
	}) => {
		const context = useContext(AppContext);

		const [page, setPage] = useState(1);
		const [tags, setTags] = useState({});

		useEffect(() => {
			getTags(page, context.siteKey).then(data => setTags(data || []));
		}, [page, context.siteKey]);

		return (
			<>
				<div className="container">
					<div className="row">
						{tags.items &&
							tags.items.map(tag => (
								<div
									className="col-md-3 question-tags"
									key={tag.id}
								>
									<Link
										className="questions-disabled-link"
										to={`/questions/${sectionTitle}/tag/${tag.taxonomyCategoryId}`}
									>
										<ClayCardWithNavigation>
											<ClayCard.Body>
												<ClayCard.Description displayType="title">
													{tag.name}
												</ClayCard.Description>
												<ClayCard.Description displayType="text">
													{lang.sub(
														Liferay.Language.get(
															'used-x-times'
														),
														[
															tag.taxonomyCategoryUsageCount,
														]
													)}
												</ClayCard.Description>
												<ClayCard.Description displayType="text">
													{lang.sub(
														Liferay.Language.get(
															'latest-usage'
														),
														[
															dateToInternationalHuman(
																tag.dateCreated
															),
														]
													)}
												</ClayCard.Description>
											</ClayCard.Body>
										</ClayCardWithNavigation>
									</Link>
								</div>
							))}
					</div>
				</div>
				{tags.lastPage > 1 && (
					<ClayPaginationWithBasicItems
						activePage={page}
						ellipsisBuffer={2}
						onPageChange={setPage}
						totalPages={Math.ceil(tags.totalCount / tags.pageSize)}
					/>
				)}
			</>
		);
	}
);
