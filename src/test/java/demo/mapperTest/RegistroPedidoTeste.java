package demo.mapperTest;

import demo.AssertionsTest.AssertionsDeRegistroPedido;
import demo.DtoFactory.PedidoDtoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RegistroPedidoTeste {



        @DisplayName("testar todos os casos")
        @Nested
        class Sucesso {



            @Test
            void Teste1() {
              //FACTORY
                var dto = PedidoDtoFactory.TodosOsCenarios();
              //ACT/ASSERTIONS

            }

            }
        }
