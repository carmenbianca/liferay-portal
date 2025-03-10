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

import {
	ADD_FRAGMENT_ENTRY_LINKS,
	ADD_FRAGMENT_ENTRY_LINK_COMMENT,
	DELETE_FRAGMENT_ENTRY_LINK_COMMENT,
	DUPLICATE_ITEM,
	EDIT_FRAGMENT_ENTRY_LINK_COMMENT,
	UPDATE_EDITABLE_VALUES,
	UPDATE_FRAGMENT_ENTRY_LINK_CONFIGURATION,
	UPDATE_FRAGMENT_ENTRY_LINK_CONTENT,
	UPDATE_LAYOUT_DATA,
} from '../actions/types';

export const INITIAL_STATE = {};

export default function fragmentEntryLinksReducer(
	fragmentEntryLinks = INITIAL_STATE,
	action
) {
	switch (action.type) {
		case ADD_FRAGMENT_ENTRY_LINKS: {
			const newFragmentEntryLinks = {};

			action.fragmentEntryLinks.forEach((fragmentEntryLink) => {
				newFragmentEntryLinks[
					fragmentEntryLink.fragmentEntryLinkId
				] = fragmentEntryLink;
			});

			return {
				...fragmentEntryLinks,
				...newFragmentEntryLinks,
			};
		}

		case ADD_FRAGMENT_ENTRY_LINK_COMMENT: {
			const fragmentEntryLink =
				fragmentEntryLinks[action.fragmentEntryLinkId];

			const {comments = []} = fragmentEntryLink;

			let nextComments;

			if (action.parentCommentId) {
				nextComments = comments.map((comment) =>
					comment.commentId === action.parentCommentId
						? {
								...comment,
								children: [
									...(comment.children || []),
									action.fragmentEntryLinkComment,
								],
						  }
						: comment
				);
			}
			else {
				nextComments = [...comments, action.fragmentEntryLinkComment];
			}

			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLink,
					comments: nextComments,
				},
			};
		}

		case DELETE_FRAGMENT_ENTRY_LINK_COMMENT: {
			const fragmentEntryLink =
				fragmentEntryLinks[action.fragmentEntryLinkId];

			const {comments = []} = fragmentEntryLink;

			let nextComments;

			if (action.parentCommentId) {
				nextComments = comments.map((comment) =>
					comment.commentId === action.parentCommentId
						? {
								...comment,
								children: comment.children.filter(
									(childComment) =>
										childComment.commentId !==
										action.commentId
								),
						  }
						: comment
				);
			}
			else {
				nextComments = comments.filter(
					(comment) => comment.commentId !== action.commentId
				);
			}

			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLink,
					comments: nextComments,
				},
			};
		}

		case DUPLICATE_ITEM: {
			const nextFragmentEntryLinks = {...fragmentEntryLinks};

			action.addedFragmentEntryLinks.forEach((fragmentEntryLink) => {
				nextFragmentEntryLinks[
					fragmentEntryLink.fragmentEntryLinkId
				] = fragmentEntryLink;
			});

			return nextFragmentEntryLinks;
		}

		case EDIT_FRAGMENT_ENTRY_LINK_COMMENT: {
			const fragmentEntryLink =
				fragmentEntryLinks[action.fragmentEntryLinkId];

			const {comments = []} = fragmentEntryLink;

			let nextComments;

			if (action.parentCommentId) {
				nextComments = comments.map((comment) =>
					comment.commentId === action.parentCommentId
						? {
								...comment,
								children: comment.children.map((childComment) =>
									childComment.commentId ===
									action.fragmentEntryLinkComment.commentId
										? action.fragmentEntryLinkComment
										: childComment
								),
						  }
						: comment
				);
			}
			else {
				nextComments = comments.map((comment) =>
					comment.commentId ===
					action.fragmentEntryLinkComment.commentId
						? {...comment, ...action.fragmentEntryLinkComment}
						: comment
				);
			}

			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLink,
					comments: nextComments,
				},
			};
		}

		case UPDATE_EDITABLE_VALUES:
			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLinks[action.fragmentEntryLinkId],
					editableValues: action.editableValues,
				},
			};

		case UPDATE_FRAGMENT_ENTRY_LINK_CONFIGURATION:
			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: action.fragmentEntryLink,
			};

		case UPDATE_FRAGMENT_ENTRY_LINK_CONTENT: {
			const fragmentEntryLink =
				fragmentEntryLinks[action.fragmentEntryLinkId];

			let collectionContent = fragmentEntryLink.collectionContent || [];

			if (action.collectionItemIndex != null) {
				collectionContent = [...collectionContent];

				collectionContent[action.collectionItemIndex] = action.content;
			}

			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLinks[action.fragmentEntryLinkId],
					collectionContent,
					content: action.content,
					editableValues:
						action.editableValues ||
						fragmentEntryLinks[action.fragmentEntryLinkId]
							.editableValues,
				},
			};
		}

		case UPDATE_LAYOUT_DATA: {
			const nextFragmentEntryLinks = {...fragmentEntryLinks};

			action.deletedFragmentEntryLinkIds.forEach(
				(fragmentEntryLinkId) => {
					delete nextFragmentEntryLinks[fragmentEntryLinkId];
				}
			);

			return nextFragmentEntryLinks;
		}

		default:
			return fragmentEntryLinks;
	}
}
