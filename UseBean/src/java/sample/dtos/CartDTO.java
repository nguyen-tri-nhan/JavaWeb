/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguyentrinhan2000
 */
public class CartDTO {
    private Map<String, TeaDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, TeaDTO> cart) {
        this.cart = cart;
    }

    public Map<String, TeaDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, TeaDTO> cart) {
        this.cart = cart;
    }
    public void add(TeaDTO dto){
        if(cart == null){
            cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getId())) {
            int quantity = this.cart.get(dto.getId()).getQuantity();
            dto.setQuantity(quantity+1);
        }
        cart.put(dto.getId(), dto);
    }
    public void delete(String id){
        if(this.cart == null){
            return;
        }
        if (this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
    public void update(String id, TeaDTO dto){
        if (this.cart != null){
            if (this.cart.containsKey(id)){
                this.cart.replace(id, dto);
            }
        }
    }
}
