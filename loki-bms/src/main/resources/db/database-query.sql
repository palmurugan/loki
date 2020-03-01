select itype.name, category.name, item.* from bms.item as item
left join bms.item_category as category on item.item_category_id=category.id
left join bms.item_type as itype on category.item_type_id=itype.id;