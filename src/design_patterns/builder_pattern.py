class BankingSystem():
    
    class Builder():
        def __init__(self, account_number):
            self.account_number = account_number
            self.acc_type   = ""
            self.ir      = 0
            self.branch         = ""
            self.owner_name     = ""
        
        def account_type(self, acc_type):
            self.acc_type = acc_type
            return self
        
        def saving_ir(self, ir):
            self.ir = ir
            return self
        
        def set_branch(self, branch_name):
            self.branch = branch_name
            return self
        
        def owner(self, o_name):
            self.owner_name = o_name
            return self
        
        def build(self):
            obj = BankingSystem()
            obj.account_number  = self.account_number
            obj.acc_type        = self.acc_type
            obj.ir              = self.ir
            obj.branch          = self.branch
            obj.owner_name      = self.owner_name
            return obj
            
    def __init__(self):
        self.account_number = 0
        self.acc_type       = ""
        self.ir             = 0
        self.branch         = ""
        self.owner_name     = ""

obj = BankingSystem.Builder(123).owner("rahul").account_type("saving").saving_ir(2.25).set_branch("Indore").build()

print(obj.branch)
print(obj.ir)
print(obj.acc_type)
print(obj.owner_name)
print(obj.account_number)
