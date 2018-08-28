package matti.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matti.eshop.service.ItemService;
import matti.eshop.service.ItemViewDto;
import matti.eshop.service.OrderService;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class ViewItemController extends SimpleFormController {

	private ItemService itemService;
	private OrderService orderService;
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public ViewItemController() {
		setCommandClass(ItemViewDto.class);
	}

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "itemId");
		
		Map<String, Object> ref = new HashMap<String, Object>();
		ref.put("item", itemService.getItemForViewing(id));
		ref.put("isInSell", itemService.isItemInSell(id));
		ref.put("isUsersUnsoldItem", itemService.isUsersUnsoldItem(id));
		return ref;
	}
	
	@SuppressWarnings("finally")
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			int itemId = ServletRequestUtils.getRequiredIntParameter(request, "itemId");
			ItemViewDto dto = itemService.getItemForViewing(itemId);
			
			int sellerId = dto.getSellerId();
			orderService.addOrder(itemId, sellerId);
			
			itemService.updateEndTime(itemId);
			
			model.put("buySucceed", true);
		}
		catch(RuntimeException e) {
			model.put("itemBought", true);
		}
		finally {
			return showForm(request, response, errors, model);
		}
	}
	
}
